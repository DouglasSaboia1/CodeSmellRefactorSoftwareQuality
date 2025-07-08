package org.example.studymaterial;

import java.util.List;

public class AudioReference extends Reference {

    public enum AudioQuality {
        LOW, MEDIUM, HIGH, VERY_HIGH;
    }

    private AudioQuality audioQuality;

    public AudioReference(AudioQuality quality) {
        this.audioQuality = quality;
    }

    public AudioQuality getAudioQuality() {
        return audioQuality;
    }

    public static AudioQuality audioQualityAdapter(String quality) {
        return switch (quality.toLowerCase()) {
            case "low" -> AudioQuality.LOW;
            case "medium" -> AudioQuality.MEDIUM;
            case "high" -> AudioQuality.HIGH;
            case "very_high" -> AudioQuality.VERY_HIGH;
            default -> null;
        };
    }

    public void setAudioQuality(AudioQuality audioQuality) {
        this.audioQuality = audioQuality;
    }

    // ✅ Método agora recebe grupos lógicos de parâmetros
    public void editAudio(AudioQuality audioQuality, boolean isDownloadable, String[] basicInfo, String[] extraInfo, int[] stats) {
        editBasic(basicInfo[0], basicInfo[1], basicInfo[2]);
        this.setAccessRights(extraInfo[0]);
        this.setLicense(extraInfo[1]);
        this.setLanguage(extraInfo[2]);
        this.setAudioQuality(audioQuality);
        editVideoAttributes(stats[0], stats[1], stats[2], isDownloadable);
    }

    // ✅ Mantemos compatibilidade com os testes
    public void editAudioAdapter(List<String> properties, List<Integer> intProperties, AudioQuality audioQuality, boolean isDownloadable) {
        String[] basicInfo = {properties.get(0), properties.get(1), properties.get(2)};
        String[] extraInfo = {properties.get(3), properties.get(4), properties.get(5)};
        int[] stats = {intProperties.get(0), intProperties.get(1), intProperties.get(2)};
        this.editAudio(audioQuality, isDownloadable, basicInfo, extraInfo, stats);
    }

    private void editVideoAttributes(int rating, int viewCount, int shareCount, boolean isDownloadable) {
        this.setRating(rating);
        this.setViewCount(viewCount);
        this.setShareCount(shareCount);
        this.setDownloadable(isDownloadable);
    }

    public void editBasic(String title, String description, String link) {
        this.setTitle(title);
        this.setDescription(description);
        this.setLink(link);
    }
}
