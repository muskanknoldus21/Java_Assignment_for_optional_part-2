package com.knoldus.kup;

import java.util.Optional;
import java.util.stream.Stream;

public class PhoneBookCrawler {

   private PhoneBook phoneBook;

   public PhoneBookCrawler(PhoneBook phoneBook) {
      this.phoneBook = phoneBook;
   }

   public String findPhoneNumberByNameAndPunishIfNothingFound(String name){
      return phoneBook.findPhoneNumberByName(name).orElseThrow(()->new IllegalArgumentException("No number found!"));
   }

   public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFound(String name){
      return phoneBook.findPhoneNumberByName(name).orElse(phoneBook.toString());
   }

//  reimplemented exercise 2 using stream
   public Optional<String> findPhoneNumberByName(String name){
      return Stream.of(phoneBook)
              .map(phoneBook1 -> Optional.ofNullable(phoneBook1.getPhoneMap()
                      .get(name)))
              .findFirst().orElse(Optional.empty());
   }

//   reimplemented exercise 3 using stream
   public String findPhoneNumberByNameAndPrintPhoneBookIfNothingFoundByStreams(String name){
      return Stream.of(phoneBook)
              .map(phoneBook1 -> Optional.ofNullable(phoneBook1
                              .getPhoneMap()
                      .get(name)).orElse(phoneBook1.toString()))
              .findFirst().get();
   }

//   exercise 7
   public String findPhoneNumberByNameOrNameByPhoneNumber(String name,String phoneNumber){
         return Stream.of(phoneBook.findPhoneNumberByName(name),phoneBook.findNameByPhoneNumber(phoneNumber))
                 .filter(Optional::isPresent)
                 .map(Optional::get)
                 .findFirst().get();
   }

}
