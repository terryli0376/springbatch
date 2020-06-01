package com.syxfjr.springbatch.controller;

import com.syxfjr.springbatch.entity.Person;
import com.syxfjr.springbatch.service.PersonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Person)表控制层
 *
 * @author makejava
 * @since 2020-05-28 15:23:21
 */
@RestController
@RequestMapping("person")
public class PersonController {
    /**
     * 服务对象
     */
    @Resource
    private PersonService personService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("selectOne")
    public Person selectOne(Integer id) {
        return this.personService.queryById(id);
    }

}