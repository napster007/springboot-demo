package web;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class PortfolioController {

    private final PortfolioService portfolioService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("portfolio", portfolioService.getPortfolio());

        return "index";
    }

    @GetMapping("/edit")
    public String edit(Model model) {
        model.addAttribute("portfolio", portfolioService.getPortfolio());

        return "edit";
    }

    @PostMapping("/edit")
    public String editPortfolio(@ModelAttribute("portfolio") Portfolio portfolio) {
        portfolioService.save(portfolio);

        return "edit";
    }
}

