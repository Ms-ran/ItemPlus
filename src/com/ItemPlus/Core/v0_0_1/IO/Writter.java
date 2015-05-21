package com.ItemPlus.Core.v0_0_1.IO;

import com.ItemPlus.Main;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author HotFlow
 */
public final class Writter
{
    private final File file;

    public Writter(File file)
    {
        this.file = file;
    }

    private void write(int index, String s)
    {
        if (!this.file.exists())
        {
            return;
        }

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                lines.add(line);
            }
            reader.close();
            file.delete();

            if (index >= lines.size())
            {
                lines.add(s);
            }

            for (int i = 0; i < lines.size(); i++)
            {
                if (i == index)
                {
                    lines.set(index, s);
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < lines.size(); i++)
            {
                writer.write(new String(lines.get(i).getBytes("gb2312"), "gb2312"));
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException ex)
        {
            Main.logger.getLogger().warning(ex.toString());
        }
    }

    private void write(String s)
    {
        if (!this.file.exists())
        {
            return;
        }

        try
        {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            ArrayList<String> lines = new ArrayList<String>();
            String line = null;
            while ((line = reader.readLine()) != null)
            {
                lines.add(line);
            }
            lines.add(s);

            reader.close();
            file.delete();

            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            for (int i = 0; i < lines.size(); i++)
            {
                writer.write(new String(lines.get(i).getBytes("gb2312"), "gb2312"));
                writer.newLine();
            }
            writer.close();
        }
        catch (IOException ex)
        {
            Main.logger.getLogger().warning(ex.toString());
        }
    }
}
