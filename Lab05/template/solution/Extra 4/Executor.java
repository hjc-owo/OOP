import java.util.ArrayList;
import java.util.List;

public class Executor {

    List<ICommand> commands = new ArrayList<>();

    void add(ICommand command) {
        commands.add(command);
    }

    void run() {
        for (ICommand command : commands) {
            command.execute();
        }
    }
}
