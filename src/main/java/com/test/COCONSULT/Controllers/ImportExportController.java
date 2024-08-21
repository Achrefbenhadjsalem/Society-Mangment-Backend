package com.test.COCONSULT.Controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ImportExportController {
/*
    @Autowired
    private ExportImportService exportImportService; // Your service class that handles import/export
    @Autowired
    InvoiceServiceImpl invoiceService;
    @Autowired
    PaymentServiceImpl paymentService ;

    @PostMapping("/import")
    public ResponseEntity<String> importData(@RequestParam("file") MultipartFile file) {
        // Call the import method in your service class and pass the file
        exportImportService.importDataFromCSV(String.valueOf(file));
        return ResponseEntity.ok("Import successful");
    }

    @GetMapping("/export")
    public ResponseEntity<Resource> exportData() {
        // Retrieve invoices and payments from your repository or service

        List<Invoice> invoices = invoiceService.retrieveInvoice(); // Assuming you have an invoice service with a method to retrieve all invoices
        List<Payment> payments = paymentService.retrievePayment(); // Assuming you have a payment service with a method to retrieve all payments

        // Provide a default file name or generate one dynamically
        String fileName = "exported_data.csv";

        // Call the export method in your service class to generate the export file
        exportImportService.exportDataToCSV(invoices, payments, fileName);

        // Provide a download link to the exported file
        Resource exportFile = new FileSystemResource(fileName); // Provide the path to your exported file
        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType("text/csv"))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + exportFile.getFilename() + "\"")
                .body(exportFile);
    }

*/
}
