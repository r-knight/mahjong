import java.io.*;
import java.util.logging.Logger;
import java.util.logging.Handler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class GameLogger{
    private static final Logger logger = Logger.getLogger(GameLogger.class.getName());
    private PrintStream stdout;
    private PrintStream outPS;

    public GameLogger(){
        try{
            this.initializeLogger();
        }
        catch(IOException e){
            System.err.println("IOException occurred when attempting to initialize logger");
        }
    }

    public GameLogger initializeLogger() throws IOException{
        File file = new File("mahjongapp.log");
        if(file.createNewFile()){
            System.out.println("log created");
        }
        else{
            System.out.println("log already exists");
        }
        Handler fh = new FileHandler("mahjongapp.log", true);
        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
        logger.setLevel(Level.FINE);

        stdout = System.out;
        outPS =
        new PrintStream(
            new BufferedOutputStream(
                new FileOutputStream("mahjongapp.log", true)));  // append is true
        System.setErr(outPS);
        System.setOut(outPS);
        return this;
    }

    public void flush(){
        this.outPS.flush();
    }

    public void closeOutPS(){
        this.outPS.close();
    }
    public void resetOutstreamToSTDOut(){
        System.setOut(stdout);
    }

    public PrintStream getStdout(){
        return stdout;
    }
    public PrintStream getOutPS(){
        return outPS;
    }
    public void setOutPS(PrintStream outPS){
        this.outPS = outPS;
    }
}