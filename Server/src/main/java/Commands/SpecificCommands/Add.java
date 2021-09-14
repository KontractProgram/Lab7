package Commands.SpecificCommands;

import Commands.Command;
import Commands.SerializedCommands.SerializedCombinedCommand;
import Utilities.Logging;
import Utilities.Receiver;
import java.io.Serializable;
import java.net.SocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.logging.Level;

public class Add extends Command implements Serializable {
    private static final long serialVersionUID = 1234567L;

    @Override
    public void execute(Object o, DatagramChannel datagramChannel, SocketAddress socketAddress){
        SerializedCombinedCommand scc = (SerializedCombinedCommand) o;
        Object obj = scc.getObject();
        String arg = scc.getArg();
        Logging.log(Level.INFO, "Server is executing Add command....");
        Receiver receiver = new Receiver(datagramChannel);
        receiver.add(arg,obj,socketAddress);
    }
}
