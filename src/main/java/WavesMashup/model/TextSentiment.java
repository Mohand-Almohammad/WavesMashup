package WavesMashup.model;

import lombok.Data;

@Data
public class TextSentiment {
    private String text;
    private int totalLines;
    private int pos;
    private int neg;
    private int mid;
    private String pos_percent;
    private String neg_percent;
    private String mid_percent;
    private String lang;

}

