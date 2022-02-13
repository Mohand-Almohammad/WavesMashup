package WavesMashup.service;

import WavesMashup.model.PricesList;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class Waves_Service {
    private final List pricesList;
    public List<PricesList> getPricesList() {
        return pricesList;
    }
}
