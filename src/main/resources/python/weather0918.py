# -*- coding: utf-8 -*-
"""
Created on Wed Sep 18 10:28:42 2019

@author: kingsirvince
"""

from bs4 import BeautifulSoup as BS
from xml.etree import ElementTree
import requests
import re
import xlwt
import xlrd
from xlrd import xldate_as_tuple
import datetime 
import time
import pymysql #支持Python3.0
from builtins import int
import logging



def getHtml(url, headers):
    print('##'*30)
    req = requests.get(url, headers=headers)
    
    if req.encoding == 'ISO-8859-1':
        encodings = requests.utils.get_encodings_from_content(req.text)
        if encodings:
            encoding = encodings[0]
        else:
            encoding = req.apparent_encoding
    else:
        encoding = req.encoding
    encode_content = req.content.decode(encoding, 'replace').encode('utf-8', 'replace').decode('utf-8')
    #print(req.text)
    return encode_content

def get_city_info(url, headers):
    data = getHtml(url, headers)
    #print(data)
    #print('##'*30)
    tree = ElementTree.fromstring(data)
    #print(tree)
    '''
    for child in tree:
        # 第二层节点的标签名称和属性
        print(child.tag,":", child.attrib) 
        # 遍历xml文档的第三层
        for children in child:
            # 第三层节点的标签名称和属性
            print(children.tag, ":", children.attrib)
    '''
    return tree

def write_data(tree, save_path):
    workbook = xlwt.Workbook(encoding = 'ascii')
    worksheet = workbook.add_sheet('My Worksheet')
    worksheet.write(0, 0, '城市')
    worksheet.write(0, 1, '天气情况')
    worksheet.write(0, 2, '最高温度')
    worksheet.write(0, 3, '最低温度')
    worksheet.write(0, 4, '当前温度')
    worksheet.write(0, 5, '风速情况') 
    worksheet.write(0, 6, '当前风速')
    worksheet.write(0, 7, '风力')
    worksheet.write(0, 8, '湿度')
    worksheet.write(0, 9, '时间')
     
    num_row = 1  
        
    for city in tree.findall("city"):
        # 查找country标签下的第一个rank标签
        cityname = city.get("cityname")
        stateDetailed = city.get("stateDetailed")
        tem1 = city.get("tem1")
        tem2 = city.get("tem2")
        temNow = city.get("temNow")
        windState= city.get("windState")
        windDir = city.get("windDir")
        windPower = city.get("windPower")
        humidity = city.get("humidity")
        time = city.get("time")
        worksheet.write(num_row, 0, label = cityname)
        worksheet.write(num_row, 1, label = stateDetailed)
        worksheet.write(num_row, 2, label = tem1)
        worksheet.write(num_row, 3, label = tem2)
        worksheet.write(num_row, 4, label = temNow)
        worksheet.write(num_row, 5, label = windState)
        worksheet.write(num_row, 6, label = windDir)
        worksheet.write(num_row, 7, label = windPower)
        worksheet.write(num_row, 8, label = humidity)
        worksheet.write(num_row, 9, label = time)
        num_row += 1
        #worksheet.write(num)
    workbook.save(save_path)

def importExcelToMysql(path):
    conn = pymysql.connect(host='localhost',port=3306,user='root',passwd='root', db='boat',charset='utf8' )
    ##打开游标
    cur = conn.cursor()
    #删除表数据
    cur.execute("delete from data_weather")
    #根据Excel路径读取Excel
    workbook = xlrd.open_workbook(path)
    sheets = workbook.sheet_names()
    #根据sheet名称获取sheet,sheets[0]为第一个表格名称
    worksheet = workbook.sheet_by_name(sheets[0])
    ##遍历行
    for i in range(1, worksheet.nrows):
        row = worksheet.row(i)
 
        ##初始化数组
        sqlstr = []
        ##遍历列
        for j in range(0, worksheet.ncols):
            ##构造数组
            sqlstr.append(worksheet.cell_value(i, j))
 
        ##插入数据库
        valuestr = [str(sqlstr[0]), str(sqlstr[1]),str(sqlstr[2]),str(sqlstr[3]),str(sqlstr[4]), str(sqlstr[5]),str(sqlstr[6]),str(sqlstr[7]),str(sqlstr[8]), str(sqlstr[9])]
 
        ##执行sql语句
        try:
            cur.execute(
                "insert into data_weather(cityname,stateDetailed,tem1,tem2,temNow,windState,windDir,windPower,humidity,time,datetime) " +
                "values(%s,%s,%s,%s,%s,%s,%s,%s,%s,%s,sysdate())",valuestr)
            conn.commit()
        except:
   # 如果发生错误则回滚
            logging.error('SQL执行失败，执行语句为：')
            conn.rollback()

    #关闭游标
    cur.close()
    #提交
    #conn.commit()
    #关闭连接
    conn.close()
    # 打印信息
    print("数据导入成功！")

def work(url, headers, save_path):
    tree_result = get_city_info(url, headers)
    write_data(tree_result, save_path)
    importExcelToMysql(path=save_path)

   
if __name__ == "__main__":
    url = r"http://flash.weather.com.cn/wmaps/xml/zhejiang.xml"
    headers = {'User-Agent':'Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/60.0.3112.113 Safari/537.36'}
    while 1:
        time_str = time.time()
        save_path = "./data_weather_{}.xls".format(time_str)
        work(url, headers, save_path)
        time.sleep(1*3600)
