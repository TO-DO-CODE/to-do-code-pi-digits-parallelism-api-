
package edu.eci.arsw.parallelism.api;

import edu.eci.arsw.parallelism.core.PiDigitsService;
import jakarta.validation.constraints.Min;
import org.springframework.web.bind.annotation.*;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping("/api/v1/pi")
@Validated
public class PiDigitsController {

    private final PiDigitsService service;

    public PiDigitsController(PiDigitsService service) {
        this.service = service;
    }

    @GetMapping("/digits")
    public PiResponse digits(
            @RequestParam @Min(0) int start,
            @RequestParam @Min(0) int count,
            @RequestParam(required = false, defaultValue = "1") @Min(1) int threads,
            @RequestParam(required = false, defaultValue = "sequential") String strategy
    ) {
        String digits = service.calculate(start, count, threads, strategy);
        return new PiResponse(start, count, digits);
    }
}
