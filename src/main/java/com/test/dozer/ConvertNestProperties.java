package com.test.dozer;

import com.test.dozer.bean.*;
import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by szh on 2017/12/1.
 */
public class ConvertNestProperties {

    public static void main(String[] args){

        Mapper mapper = new DozerBeanMapper();

        RebateRuleDTO rebateRuleDTO = new RebateRuleDTO();
        rebateRuleDTO.setRebateRuleId(1);
        rebateRuleDTO.setRebateRuleName("测试规则");
        rebateRuleDTO.setRebateRuleDescri("不被传递的值");

        List<RebateDTO> rebateDTOList = new ArrayList<>();
        RebateDTO rebateDTO1 = new RebateDTO();
        rebateDTO1.setRebateId(1);
        rebateDTO1.setFixed(12.0);
        rebateDTO1.setFloor(10.0);
        rebateDTO1.setUpper(20.0);
        rebateDTOList.add(rebateDTO1);

        rebateRuleDTO.setRebateDTOList(rebateDTOList);

        System.out.println("DTO to VO");
        RebateRuleVO rebateRuleVO = mapper.map(rebateRuleDTO ,RebateRuleVO.class);

        System.out.println("RebateRuleVO rebateList size " + rebateRuleVO.getRebateVOList().size());
        List<RebateVO> rebateVOListVO = rebateRuleVO.getRebateVOList();
        for(int i=0; i<rebateVOListVO.size(); i++){
            System.out.println("index " + i);
            System.out.println(rebateVOListVO.get(i));
        }

    }

}
