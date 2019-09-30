package sql01;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/regit")
    @ResponseBody
    public String  regit(@RequestParam String name , @RequestParam String pwd){
        return userService.regit(name,pwd);
    }

    @RequestMapping("/get")
    @ResponseBody
    public String get(@RequestParam Long id){
        String name = userService.get(id);
        return name;

    }

    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){
    return "你好";
    }
}
