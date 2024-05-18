import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class TelegramBotSender extends TelegramLongPollingBot {

    private final String BOT_TOKEN = "6703350782:AAE18L812rhkYgVku_2lyVd1iCE4CAfXgew";
    private final String CHAT_ID = "1732733890";

    @Override
    public String getBotToken() {
        return BOT_TOKEN;
    }

    @Override
    public String getBotUsername() {
        return "YourBotName";
    }

    @Override
    public void onUpdateReceived(Update update) {
        // This method is mandatory but can be left empty for this example
    }

    public void sendMessage(String messageText) {
        SendMessage message = new SendMessage();
        message.setChatId(CHAT_ID);
        message.setText(messageText);

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            String message = args[0];
            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
            try {
                TelegramBotSender bot = new TelegramBotSender();
                botsApi.registerBot(bot);
                bot.sendMessage(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }
}
