package ispy.api.v1;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Result
{
    public Boolean  success = true;
    public String   payload = "";
    public String   message = "";

    public Result() {}

    public Result(Boolean success)
    {
        this.success = success;
    }

    public Result(Boolean success, String payload)
    {
        this.success = success;
        this.payload = payload;
    }

    public Result(Boolean success, String payload, String message)
    {
        this.success = success;
        this.payload = payload;
        this.message = message;
    }

    public Boolean getSuccess()
    {
        return this.success;
    }

    public String getPayload()
    {
        return this.payload;
    }

    public String getMessage()
    {
        return this.message;
    }
}
