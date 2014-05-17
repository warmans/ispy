package ispy.guesser;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Guess
{
    public String thing;

    public Guess() {}

    public Guess(String thing)
    {
        this.thing = thing;
    }

    public String getThing()
    {
        return this.thing;
    }
}
