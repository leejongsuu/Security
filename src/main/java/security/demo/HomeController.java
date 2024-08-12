package security.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private SecurityContextService securityContextService;

    @GetMapping("/")
    public String index() {
        SecurityContext context = SecurityContextHolder.getContextHolderStrategy().getContext();
        Authentication authentication = context.getAuthentication();
        System.out.println("authentication = " + authentication);

        securityContextService.SecurityContext();

        return "index";
    }

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/loginPage")
    public String login() {
        return "login";
    }

    @GetMapping("/failed")
    public String fail() {
        return "fail";
    }
}
