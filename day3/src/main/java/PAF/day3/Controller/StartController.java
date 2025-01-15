package PAF.day3.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping({"/","index.html"})
public class StartController {
    
    @GetMapping()
    public String start(){
        return "search";
    }
}
