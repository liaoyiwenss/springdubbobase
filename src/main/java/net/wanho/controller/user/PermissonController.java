package net.wanho.controller.user;


import net.wanho.service.user.PermissonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/dopermission")
public class PermissonController {


    @Autowired
    private PermissonService permissonService;



    @RequestMapping("/queryallPermissonbyRoleid")
    @ResponseBody
    public List<Map<String, Object>> queryallPermissonbyRoleid(Long roleid){

        List<Map<String, Object>> maps = permissonService.selectRoleandPermission(roleid);

        return maps;
    }


}
