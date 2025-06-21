package week1;

public class Factory_method_pattern {

    // Step 2: Define Document interface
    interface Document {
        void open();
    }

    // Step 3: Concrete Document Classes

    static class WordDocument implements Document {
        public void open() {
            System.out.println("Opening a Word document.");
        }
    }

    static class PdfDocument implements Document {
        public void open() {
            System.out.println("Opening a PDF document.");
        }
    }

    static class ExcelDocument implements Document {
        public void open() {
            System.out.println("Opening an Excel document.");
        }
    }

    // Step 4: Define the Factory (Abstract)
    static abstract class DocumentFactory {
        public abstract Document createDocument();
    }

    // Step 4.1: Concrete Factories

    static class WordDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new WordDocument();
        }
    }

    static class PdfDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new PdfDocument();
        }
    }

    static class ExcelDocumentFactory extends DocumentFactory {
        public Document createDocument() {
            return new ExcelDocument();
        }
    }

    // Step 5: Test class
    public static void main(String[] args) {
        // Create Word Document
        DocumentFactory wordFactory = new WordDocumentFactory();
        Document wordDoc = wordFactory.createDocument();
        wordDoc.open();

        // Create PDF Document
        DocumentFactory pdfFactory = new PdfDocumentFactory();
        Document pdfDoc = pdfFactory.createDocument();
        pdfDoc.open();

        // Create Excel Document
        DocumentFactory excelFactory = new ExcelDocumentFactory();
        Document excelDoc = excelFactory.createDocument();
        excelDoc.open();
    }
}

