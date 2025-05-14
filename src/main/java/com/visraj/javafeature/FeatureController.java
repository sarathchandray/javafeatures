import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class FeatureController {

    @GetMapping("/greet")
    public String greet() {

        return "Hi Sarath!";
    }
}