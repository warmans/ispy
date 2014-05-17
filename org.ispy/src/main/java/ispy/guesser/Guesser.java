package ispy.guesser;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;

import ispy.guesser.Something;
import ispy.guesser.Guess;

public class Guesser
{
    private Connection db;
    public String item;

    public Guesser(Connection db)
    {
        this.db = db;
    }

    public Guess guess(Something something)
    {
        return new Guess(this.findThing(something.getLetter()));
    }

    private String findThing(String letter)
    {
        try {
            PreparedStatement statement = this.db.prepareStatement("SELECT name FROM things WHERE name LIKE ? LIMIT 1");
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.setString(1, letter + "%");

            ResultSet rs = statement.executeQuery();
            while(rs.next())
            {
                return rs.getString("name");
            }

            throw new RuntimeException("I have no idea");

        } catch (SQLException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("Can't think of anything right now");
        }
    }
}
