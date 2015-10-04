package Tools;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public interface AcceptMessage<MessageType> {
    public void receiveMessage(Message<MessageType> message);
}
