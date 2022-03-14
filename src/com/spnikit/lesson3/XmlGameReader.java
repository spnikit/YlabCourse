package com.spnikit.lesson3;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;

class XmlGameReader {
    private XMLStreamReader xmlsr;
    private Gameplay gameplay;

    XmlGameReader(String filename) {
        try {
            Reader reader = new FileReader(filename);
            xmlsr = XMLInputFactory.newFactory().createXMLStreamReader(reader);
        } catch (FileNotFoundException | XMLStreamException e) {
            e.printStackTrace();
        }
    }

    private Gameplay parseXmlFile() throws XMLStreamException {
        gameplay = new Gameplay();

        while (xmlsr.hasNext()) {
            if (xmlsr.next() == XMLStreamReader.START_ELEMENT) {
                if (xmlsr.getName().toString().equalsIgnoreCase("Player")) {

                    var playerId = Integer.parseInt(xmlsr.getAttributeValue(null, "id"));
                    var playerName = xmlsr.getAttributeValue(null, "name");

                    if (gameplay.getPlayer1() == null) {
                        gameplay.setPlayer1(new Player(
                                playerName,
                                playerId == 1 ? PlayerNumber.ONE : PlayerNumber.TWO
                        ));
                    } else if (gameplay.getPlayer2() == null) {
                        gameplay.setPlayer2(new Player(
                                playerName,
                                playerId == 1 ? PlayerNumber.ONE : PlayerNumber.TWO
                        ));
                    } else {
                        gameplay.setWinner(new Player(
                                playerName,
                                playerId == 1 ? PlayerNumber.ONE : PlayerNumber.TWO
                        ));
                    }
                }

                if (xmlsr.getName().toString().equalsIgnoreCase("Step")) {
                    var stepNumber = xmlsr.getAttributeValue(null, "num");
                    var playerNumber = xmlsr.getAttributeValue(null, "playerId");
                    var stepValue = xmlsr.getElementText();
                    var stepValueParsed = stepValue.replaceAll("\\D", "").split("");

                    gameplay.addStep(new Step(
                            Integer.parseInt(stepNumber),
                            Integer.parseInt(stepValueParsed[0]),
                            Integer.parseInt(stepValueParsed[1]),
                            playerNumber
                    ));
                }
            }
        }

        return gameplay;
    }

    public Gameplay getGameplay() {
        try {
            return this.parseXmlFile();
        } catch (XMLStreamException e) {
            e.printStackTrace();
            System.out.println("XML file wasn't parsed!");
        }

        return gameplay;
    }


}
