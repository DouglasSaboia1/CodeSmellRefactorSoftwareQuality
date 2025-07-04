package org.example.studymaterial;

public class TextReference extends Reference {

    public enum Format {
        PDF, DOC, HTML, TXT
    }

    private int wordCount;
    private Format format;

    public TextReference(String title, String language, int wordCount, String format, String accessRights) {
        this.setTitle(title);
        this.setLanguage(language);
        this.setAccessRights(accessRights);
        setWordCount(wordCount);
        setFormat(format);
    }

    // Setters privados para evitar alterações externas indiscriminadas
    private void setWordCount(int wordCount) {
        if (wordCount < 0) {
            throw new IllegalArgumentException("wordCount não pode ser negativo");
        }
        this.wordCount = wordCount;
    }

    private void setFormat(String format) {
        try {
            this.format = Format.valueOf(format.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Formato inválido: " + format);
        }
    }

    // Só expomos getters públicos que fazem sentido
    public int getWordCount() {
        return wordCount;
    }

    public Format getFormat() {
        return format;
    }

    /**
     * Atualiza dados da referência de texto em lote, com validações internas
     */
    public void updateTextData(String accessRights, String format, int wordCount) {
        this.setAccessRights(accessRights);
        setFormat(format);
        setWordCount(wordCount);
    }

    /**
     * Lógica de negócio que determina se o texto pode ser acessado
     */
    public boolean canAccess() {
        return "Public".equalsIgnoreCase(getAccessRights())
                && this.format == Format.PDF
                && this.wordCount > 0;
    }
}
