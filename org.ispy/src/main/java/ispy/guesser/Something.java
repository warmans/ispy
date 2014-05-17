package ispy.guesser;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Something
{
    public String letter;

    public Something() {}

    public Something(String letter)
    {
        this.letter = letter;
    }

    public String getLetter()
    {
        return letter;
    }
}
