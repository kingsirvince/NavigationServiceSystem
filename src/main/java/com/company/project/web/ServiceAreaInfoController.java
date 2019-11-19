package com.company.project.web;

import com.company.project.core.Result;
import com.company.project.core.ResultGenerator;
import com.company.project.model.ServiceAreaInfo;
import com.company.project.model.distance.ServiceAreaInfoDistance;
import com.company.project.service.ServiceAreaInfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.mapper.entity.Condition;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by CodeGenerator on 2019/08/12.
 */
@RestController
@RequestMapping("/service/area/info")
public class ServiceAreaInfoController {
    @Resource
    private ServiceAreaInfoService serviceAreaInfoService;

    /**
     * 按条件查询   (例如查询“梧桐作业区“）
     *
     * @param fieldName 代表字段名（Model中的成员变量，DockInfo）   fieldName=dockName
     * @param value     可以不是唯一的（返回多个List）              value=梧桐作业区
     */
    @PostMapping("/findByCondition")
    public Result findByCondition(@RequestParam String fieldName, @RequestParam Object value,@RequestParam(defaultValue = "requestId:0") String requestId) {

        Condition condition = new Condition(ServiceAreaInfo.class);
        Example.Criteria criteria = condition.createCriteria();
        criteria.orEqualTo(fieldName, value);

        List<ServiceAreaInfo> list = serviceAreaInfoService.findByCondition(condition);
        return ResultGenerator.genSuccessResult(list);
    }

    /**
     * 单项查询    查某行某列的单项值
     *
     * @param fieldName  确定某行
     * @param value
     * @param fieldName1 确定某列
     *                   sql: select fieldName1 from table where fieldName = value
     *                   select Berth_surplus_cy from `service_area_info` where Berth_name='芦花荡水上综合服务区锚泊区'
     * @return
     */
    @PostMapping("/singleQuery")
    public Result singleQuery(@RequestParam String fieldName, @RequestParam String value, @RequestParam String fieldName1,@RequestParam(defaultValue = "requestId:0") String requestId) {
        serviceAreaInfoService.singleQuery(fieldName, value, fieldName1);
        return ResultGenerator.genSuccessResult();
    }
    /**
     * 按距离排序：  输入经纬度和需要返回数量，返回按距离最近的num个记录
     * @param longitude
     * @param latitude
     * @param num   需要返回数量（可以不写，默认是5个）
     * @return
     */
    @PostMapping("/sortByDistance")
    public Result sortByDistance(@RequestParam BigDecimal longitude, @RequestParam BigDecimal latitude, @RequestParam(defaultValue = "5") Integer num,@RequestParam(defaultValue = "requestId:0") String requestId) {
        List<ServiceAreaInfoDistance> list = serviceAreaInfoService.sortByDistance(longitude, latitude, num);
        return ResultGenerator.genSuccessResult(list);
    }
    @PostMapping("/add")
    public Result add(ServiceAreaInfo serviceAreaInfo,@RequestParam(defaultValue = "requestId:0") String requestId) {
        serviceAreaInfoService.save(serviceAreaInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/delete")
    public Result delete(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        serviceAreaInfoService.deleteById(id);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/update")
    public Result update(ServiceAreaInfo serviceAreaInfo,@RequestParam(defaultValue = "requestId:0") String requestId) {
        serviceAreaInfoService.update(serviceAreaInfo);
        return ResultGenerator.genSuccessResult();
    }

    @PostMapping("/detail")
    public Result detail(@RequestParam Integer id,@RequestParam(defaultValue = "requestId:0") String requestId) {
        ServiceAreaInfo serviceAreaInfo = serviceAreaInfoService.findById(id);
        return ResultGenerator.genSuccessResult(serviceAreaInfo);
    }

    @PostMapping("/list")
    public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size,@RequestParam(defaultValue = "requestId:0") String requestId) {
        PageHelper.startPage(page, size);
        List<ServiceAreaInfo> list = serviceAreaInfoService.findAll();
        PageInfo pageInfo = new PageInfo(list);
        return ResultGenerator.genSuccessResult(pageInfo);
    }
}
