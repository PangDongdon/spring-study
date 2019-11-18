package com.dongdong.spring.service.stateMachine;

import javafx.util.Builder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;

import java.lang.annotation.Target;
import java.util.EnumSet;

/**
 * @Description:
 * @Date: 2019/11/13  11:22
 * @Author: dongdong
 */
@Configuration
@EnableStateMachine
class Config1 extends  EnumStateMachineConfigurerAdapter<Config1.States, Config1.Events>  {

    Config1() throws Exception {
    }

    @Override
    public void configure(StateMachineStateConfigurer<States,Events> states) throws Exception{
         states.withStates()
                 .initial(States.STATES1)
                 .states(EnumSet.allOf(States.class));
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<States, Events> transitions ) throws Exception{

       transitions.withExternal().
               source(States.STATES1).
               target(States.STATES2).
               event(Events.EVENTS1).
                 and().
               withExternal().
               source(States.STATES2).
               target(States.STATES1).
               event(Events.EVENTS2);

    }

   static enum States{
        STATES1,STATES2
    }

    static enum Events{
        EVENTS1, EVENTS2
    }

    public  static  StateMachine<States,Events> buildMachine() throws  Exception {
        StateMachineBuilder.Builder<States, Events> builder= StateMachineBuilder.builder();
        builder.configureStates().withStates().initial(States.STATES1).states(EnumSet.allOf(States.class));

        builder.configureTransitions().withExternal().source(States.STATES1).target(States.STATES2).event(Events.EVENTS1).and()
                .withExternal().source(States.STATES2).target(States.STATES1).event(Events.EVENTS2);
        return builder.build();
    }

    public static void main(String[] args) throws  Exception{
        StateMachine<States,Events> stateMachine = buildMachine();
        stateMachine.start();
        stateMachine.sendEvent(Events.EVENTS1);
        stateMachine.sendEvent(Events.EVENTS2);
    }

    @WithStateMachine
    static class MyBean{
       @OnTransition(target="STATE1")
       void toState1(){

       }

        @OnTransition(target="STATE2")
        void toState2(){

        }

    }

    static class MyApp{
        @Autowired
        StateMachine<States,Events> stateMachine;
        void doSignals(){
            stateMachine.start();
            stateMachine.sendEvent(Events.EVENTS1);
            stateMachine.sendEvent(Events.EVENTS2);
        }


    }


 }
