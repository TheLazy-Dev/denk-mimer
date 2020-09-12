import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.polls.StopPoll;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.meta.generics.LongPollingBot;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class DenkMimerBot extends TelegramLongPollingBot {
BotSession botSession = new BotSession() {
    @Override
    public void setOptions(BotOptions botOptions) {

    }

    @Override
    public void setToken(String s) {

    }

    @Override
    public void setCallback(LongPollingBot longPollingBot) {

    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    @Override
    public boolean isRunning() {
        return false;
    }
};
    SendMessage message = new SendMessage();
    String[] roast = {
            "My name must taste good because it’s always in your mouth.", "Don’t you get tired of putting make up on two faces every morning?",
           "Too bad you can’t count jumping to conclusions and running your mouth as exercise. ",
            "Is your drama going to an intermission soon?","I’m an acquired taste. If you don’t like me, acquire some taste. ",
            "My phone battery lasts longer than your relationships.","Oh you’re talking to me, I thought you only talked behind my back."
    };
    String[] roastdark = {
            "Your face makes onions cry.", "You look so pretty. Not at all gross, today.",
            "’m not insulting you, I’m describing you.",
            "If you’re going to be two-faced, at least make one of them pretty.","I thought of you today. It reminded me to take out the trash.",
            "I love what you’ve done with your hair. \nHow do you get it to come out of your nostrils like that?",
            "You are so full of shit, the toilet’s jealous."
    };
    public void onUpdateReceived(Update update) {
        String Command = update.getMessage().getText().trim();
        switch(Command){
            case "/roast":
                Random random = new Random();
                Collections.shuffle(Arrays.asList(roast));
                int nextString = random.nextInt(roast.length);
                message.setText(roast[nextString]);
                break;
            case "/kill":
                message.setText("marunga bhadwe");
                break;
            case "/start":
                message.setText("Ready to roast ;_;");
                break;
            case "/roastdark":
                Roastdark();
                break;
            case "/stop":
                message.setText("You look roasted \nI will take some rest now" +
                        "\nTo initiate again use start command");
                botSession.stop();

                break;
            default:
                message.setText("");
                break;
        }

        message.setChatId(update.getMessage().getChatId());
        try{
            execute(message);
        }catch (Exception e){
            System.out.println(Command);
            e.printStackTrace();
        }
    }

    public String getBotUsername() {
        return "Denk Mimer Bot";
    }

    public String getBotToken() {
        return "1394685669:AAEdUCqCBhtYwMUlYnXK11-7pP2i95XUG4g";
    }
    public void Roastdark(){
        Random random = new Random();
        int nextString = random.nextInt(roast.length);
        Collections.shuffle(Arrays.asList(roastdark));
        message.setText(roastdark[nextString]);
    }
}
