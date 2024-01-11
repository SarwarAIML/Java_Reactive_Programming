package com.gs.rp.sec11_sinks;


import com.gs.rp.courseutil.Util;
import com.gs.rp.sec11_sinks.assignments.SlackMember;
import com.gs.rp.sec11_sinks.assignments.SlackRoom;

public class Lec07SlackDemo {

    public static void main(String[] args) {

        SlackRoom slackRoom = new SlackRoom("reactor");

        SlackMember sam = new SlackMember("sam");
        SlackMember jake = new SlackMember("jake");
        SlackMember mike = new SlackMember("mike");

        slackRoom.joinRoom(sam);
        slackRoom.joinRoom(jake);

        sam.says("Hi all..");
        Util.sleepSecond(4);

        jake.says("Hey!");
        sam.says("I simply wanted to say hi..");
        Util.sleepSecond(4);

        slackRoom.joinRoom(mike);
        mike.says("Hey guys..glad to be here...");




    }



}