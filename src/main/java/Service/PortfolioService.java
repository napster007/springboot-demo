package Service;

import Model.Portfolio;

import java.time.LocalDate;
import java.util.Optional;
import javax.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class PortfolioService {

    private final PortfolioDao portfolioDao;

    public Portfolio getPortfolio() {
        return portfolioDao.findAll().get(0);
    }

    private int getMyAge() {
        LocalDate today = LocalDate.now();
        return today.getYear() - 1988;
    }

    @Transactional
    public void save(Portfolio portfolio) {
        Optional<Portfolio> searchedPortfolio = portfolioDao.findById("portfolio-12345");

        if (searchedPortfolio.isPresent()) {
            Portfolio updatedPortfolio = searchedPortfolio.get();
            updatedPortfolio.setFirstName(portfolio.getFirstName());
            updatedPortfolio.setLastName(portfolio.getLastName());

            portfolioDao.save(updatedPortfolio);
        }
    }
}
