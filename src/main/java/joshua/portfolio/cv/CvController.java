package joshua.portfolio.cv;

import joshua.portfolio.exceptions.custom.ResourceNotFoundException;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cv")
public class CvController {

    @GetMapping
    public ResponseEntity<Resource> getCv(
            @RequestParam(defaultValue = "false") boolean download) {

        Resource resource = new ClassPathResource("static/cv/josh-cv.pdf");

        if (!resource.exists())
        {
            throw new ResourceNotFoundException("CV not found");
        }

        // If download param is true - force download
        // If false - open in browser/modal
        String contentDisposition = download
                ? "attachment; filename=josh-grandin-cv.pdf"
                : "inline; filename=josh-grandin-cv.pdf";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, contentDisposition)
                .contentType(MediaType.APPLICATION_PDF)
                .body(resource);
    }

}
