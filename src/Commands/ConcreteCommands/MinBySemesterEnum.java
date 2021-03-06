package Commands.ConcreteCommands;

import Commands.Command;
import Interfaces.CommandReceiver;
import com.google.inject.Inject;

import java.io.IOException;

/**
 * Конкретная команда подсчета миниммального семестра.
 */
public class MinBySemesterEnum extends Command {
    private static final long serialVersionUID = 32L;
    transient private final CommandReceiver commandReceiver;

    @Inject
    public MinBySemesterEnum(CommandReceiver commandReceiver) {
        this.commandReceiver = commandReceiver;
    }

    @Override
    protected void execute(String[] args) throws IOException, ClassNotFoundException, InterruptedException {
        if (args.length > 1) {
            System.out.println("Введен не нужный аргумент. Команда приведена к базовой команде min_by_semester_enum.");
        }
        commandReceiver.minBySemesterEnum();
    }

    @Override
    public String getName() {
        return "min_by_semester_enum";
    }

    @Override
    protected String writeInfo() {
        return String.format(commandReceiver.getCurrentBundle().getString("minBySemesterEnumInf"),"min_by_semester_enum","semesterEnum");
    }
}
