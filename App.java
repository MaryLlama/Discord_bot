package com.discord.Anthem;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.User;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class App extends ListenerAdapter{
    @SuppressWarnings("deprecation")
	public static void main( String[] args ) throws Exception{
    	JDA jda = new JDABuilder(AccountType.BOT).setToken(Ref.token).buildBlocking();
    	jda.addEventListener(new App());
    }
    @Override
    public void onMessageReceived(MessageReceivedEvent evt) {
    	
    	//Objects 
    	User objUser = evt.getAuthor(); //The User who put the command
    	MessageChannel objMsgCh= evt.getChannel(); //The channel the User is in
    	Message objMesg = evt.getMessage(); //The message that was sent/said/typed.
    	
    	//Commands
    	
    /** Here the command is saying if the content typed by a user consists of
     * "h!ping", no matter if it was case correct, the bot should respond as
     * pinging the user and sending/saying/typing "pong!" back.
     */
    	if(objMesg.getContentRaw().equalsIgnoreCase(Ref.prefix + "ping")) {
    		objMsgCh.sendMessage(objUser.getAsMention() + "pong!").queue();
    	}
    }
}
