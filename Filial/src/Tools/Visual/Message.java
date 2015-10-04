package Tools.Visual;

import java.util.Objects;

/**
 * Created by Gustavo Freitas on 03/10/2015.
 */
public class Message<MessageType> {

    protected MessageType mensagem;

    public MessageType getMensage(){
        return (this.mensagem);
    }

    public void setMessage(MessageType message){
        this.mensagem = message;
    }

}
