package com.avotrack.avotrack.config;

import com.avotrack.avotrack.Global;
import com.avotrack.avotrack.models.Aircraft;
import com.avotrack.avotrack.services.AircraftService;
import com.avotrack.avotrack.services.InsertDb;
import com.avotrack.avotrack.services.PayloadParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.core.MessageProducer;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;


@Configuration
public class MQTT {

    private PayloadParser parser = new PayloadParser();



    @Autowired
    AircraftService aircraftService;

    @Autowired
    InsertDb insertDb;

    @Bean
    public MessageChannel mqttInputChannel () {
        return  new DirectChannel();
    }

    @Bean
    public MessageProducer inbound () {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("tcp://160.1.34.251:1883", "client-avo", "topic/mlat");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(0);
        adapter.setOutputChannel(mqttInputChannel());
        return adapter;
    }

    @Bean
    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler handler() {
        return message -> {
            JSONArray planeData = new JSONArray(message.getPayload().toString());
            List<Aircraft> new_aircrafts = new ArrayList<>();

            for(int i =0; i<planeData.length(); i++) {
                JSONObject plane = planeData.getJSONObject(i);
                try {
                    new_aircrafts.add(parser.createAircraft(plane));
                } catch (JsonProcessingException e) {
                    e.printStackTrace();
                }
            }


            aircraftService.processAircraft(new_aircrafts);
        };
    }
}
