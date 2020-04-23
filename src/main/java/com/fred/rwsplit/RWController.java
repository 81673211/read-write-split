package com.fred.rwsplit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RWController {

    @Autowired
    private RWService rwService;

    @RequestMapping("/{id}")
    public Object foo(@PathVariable("id") int id) {
        return rwService.get(id);
    }

    @RequestMapping("/insert")
    public void foo(@RequestParam("name") String name) {
        rwService.insert(name);
    }
}
