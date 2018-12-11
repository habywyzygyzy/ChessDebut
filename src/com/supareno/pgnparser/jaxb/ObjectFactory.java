/*
 * ObjectFactory.java
 * 
 * This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference
 * Implementation, vJAXB 2.1.10 in JDK 6
 * See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a>
 * 
 * Copyright 2008-2014 supareno
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.supareno.pgnparser.jaxb;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

/**
 * This object contains factory methods for each
 * Java content interface and Java element interface
 * generated in the com.supareno.pgnparser.jaxb package.
 * <p>
 * An ObjectFactory allows you to programatically construct new instances of the Java representation
 * for XML content. The Java representation of XML content can consist of schema derived interfaces
 * and classes representing the binding of schema type definitions, element declarations and model
 * groups. Factory methods for each of these are provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

  private final static QName _Result_QNAME = new QName ( "" , "result" );
  private final static QName _EventDate_QNAME = new QName ( "" , "eventDate" );
  private final static QName _Variation_QNAME = new QName ( "" , "variation" );
  private final static QName _UTCTime_QNAME = new QName ( "" , "UTCTime" );
  private final static QName _Round_QNAME = new QName ( "" , "round" );
  private final static QName _Date_QNAME = new QName ( "" , "date" );
  private final static QName _Stage_QNAME = new QName ( "" , "stage" );
  private final static QName _BlackNA_QNAME = new QName ( "" , "blackNA" );
  private final static QName _WhiteTitle_QNAME = new QName ( "" , "whiteTitle" );
  private final static QName _UTCDate_QNAME = new QName ( "" , "UTCDate" );
  private final static QName _Time_QNAME = new QName ( "" , "time" );
  private final static QName _Event_QNAME = new QName ( "" , "event" );
  private final static QName _FEN_QNAME = new QName ( "" , "FEN" );
  private final static QName _WhiteNA_QNAME = new QName ( "" , "whiteNA" );
  private final static QName _WhiteType_QNAME = new QName ( "" , "whiteType" );
  private final static QName _BlackUSCF_QNAME = new QName ( "" , "blackUSCF" );
  private final static QName _WhiteElo_QNAME = new QName ( "" , "whiteElo" );
  private final static QName _Black_QNAME = new QName ( "" , "black" );
  private final static QName _Termination_QNAME = new QName ( "" , "termination" );
  private final static QName _SetUp_QNAME = new QName ( "" , "setUp" );
  private final static QName _TimeControl_QNAME = new QName ( "" , "timeControl" );
  private final static QName _Site_QNAME = new QName ( "" , "site" );
  private final static QName _BlackTitle_QNAME = new QName ( "" , "blackTitle" );
  private final static QName _Nic_QNAME = new QName ( "" , "nic" );
  private final static QName _SubVariation_QNAME = new QName ( "" , "subVariation" );
  private final static QName _White_QNAME = new QName ( "" , "white" );
  private final static QName _Board_QNAME = new QName ( "" , "board" );
  private final static QName _BlackElo_QNAME = new QName ( "" , "blackElo" );
  private final static QName _Section_QNAME = new QName ( "" , "section" );
  private final static QName _BlackType_QNAME = new QName ( "" , "blackType" );
  private final static QName _Opening_QNAME = new QName ( "" , "opening" );
  private final static QName _EventSponsor_QNAME = new QName ( "" , "eventSponsor" );
  private final static QName _WhiteUSCF_QNAME = new QName ( "" , "whiteUSCF" );
  private final static QName _Eco_QNAME = new QName ( "" , "eco" );

  /**
   * Create a new ObjectFactory that can be used to create new instances of schema derived classes
   * for package: com.supareno.pgnparser.jaxb
   * 
   */
  public ObjectFactory () {
  }

  /**
   * Create an instance of {@link Hits }
   * 
   */
  public Hits createHits () {
    return new Hits ();
  }

  /**
   * Create an instance of {@link Games }
   * 
   */
  public Games createGames () {
    return new Games ();
  }

  /**
   * Create an instance of {@link Hit }
   * 
   */
  public Hit createHit () {
    return new Hit ();
  }

  /**
   * Create an instance of {@link Game }
   * 
   */
  public Game createGame () {
    return new Game ();
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "result" )
  public JAXBElement<String> createResult ( String value ) {
    return new JAXBElement<String> ( _Result_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "eventDate" )
  public JAXBElement<String> createEventDate ( String value ) {
    return new JAXBElement<String> ( _EventDate_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "variation" )
  public JAXBElement<String> createVariation ( String value ) {
    return new JAXBElement<String> ( _Variation_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "UTCTime" )
  public JAXBElement<String> createUTCTime ( String value ) {
    return new JAXBElement<String> ( _UTCTime_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "round" )
  public JAXBElement<String> createRound ( String value ) {
    return new JAXBElement<String> ( _Round_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "date" )
  public JAXBElement<String> createDate ( String value ) {
    return new JAXBElement<String> ( _Date_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "stage" )
  public JAXBElement<String> createStage ( String value ) {
    return new JAXBElement<String> ( _Stage_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "blackNA" )
  public JAXBElement<String> createBlackNA ( String value ) {
    return new JAXBElement<String> ( _BlackNA_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "whiteTitle" )
  public JAXBElement<String> createWhiteTitle ( String value ) {
    return new JAXBElement<String> ( _WhiteTitle_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "UTCDate" )
  public JAXBElement<String> createUTCDate ( String value ) {
    return new JAXBElement<String> ( _UTCDate_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "time" )
  public JAXBElement<String> createTime ( String value ) {
    return new JAXBElement<String> ( _Time_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "event" )
  public JAXBElement<String> createEvent ( String value ) {
    return new JAXBElement<String> ( _Event_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "FEN" )
  public JAXBElement<String> createFEN ( String value ) {
    return new JAXBElement<String> ( _FEN_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "whiteNA" )
  public JAXBElement<String> createWhiteNA ( String value ) {
    return new JAXBElement<String> ( _WhiteNA_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "whiteType" )
  public JAXBElement<String> createWhiteType ( String value ) {
    return new JAXBElement<String> ( _WhiteType_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "blackUSCF" )
  public JAXBElement<String> createBlackUSCF ( String value ) {
    return new JAXBElement<String> ( _BlackUSCF_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "whiteElo" )
  public JAXBElement<String> createWhiteElo ( String value ) {
    return new JAXBElement<String> ( _WhiteElo_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "black" )
  public JAXBElement<String> createBlack ( String value ) {
    return new JAXBElement<String> ( _Black_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "termination" )
  public JAXBElement<String> createTermination ( String value ) {
    return new JAXBElement<String> ( _Termination_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "setUp" )
  public JAXBElement<String> createSetUp ( String value ) {
    return new JAXBElement<String> ( _SetUp_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "timeControl" )
  public JAXBElement<String> createTimeControl ( String value ) {
    return new JAXBElement<String> ( _TimeControl_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "site" )
  public JAXBElement<String> createSite ( String value ) {
    return new JAXBElement<String> ( _Site_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "blackTitle" )
  public JAXBElement<String> createBlackTitle ( String value ) {
    return new JAXBElement<String> ( _BlackTitle_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "nic" )
  public JAXBElement<String> createNic ( String value ) {
    return new JAXBElement<String> ( _Nic_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "subVariation" )
  public JAXBElement<String> createSubVariation ( String value ) {
    return new JAXBElement<String> ( _SubVariation_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "white" )
  public JAXBElement<String> createWhite ( String value ) {
    return new JAXBElement<String> ( _White_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "board" )
  public JAXBElement<String> createBoard ( String value ) {
    return new JAXBElement<String> ( _Board_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "blackElo" )
  public JAXBElement<String> createBlackElo ( String value ) {
    return new JAXBElement<String> ( _BlackElo_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "section" )
  public JAXBElement<String> createSection ( String value ) {
    return new JAXBElement<String> ( _Section_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "blackType" )
  public JAXBElement<String> createBlackType ( String value ) {
    return new JAXBElement<String> ( _BlackType_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "opening" )
  public JAXBElement<String> createOpening ( String value ) {
    return new JAXBElement<String> ( _Opening_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "eventSponsor" )
  public JAXBElement<String> createEventSponsor ( String value ) {
    return new JAXBElement<String> ( _EventSponsor_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "whiteUSCF" )
  public JAXBElement<String> createWhiteUSCF ( String value ) {
    return new JAXBElement<String> ( _WhiteUSCF_QNAME , String.class , null , value );
  }

  /**
   * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}
   * 
   */
  @XmlElementDecl ( namespace = "" , name = "eco" )
  public JAXBElement<String> createEco ( String value ) {
    return new JAXBElement<String> ( _Eco_QNAME , String.class , null , value );
  }

}
