package no.ntnu.idatt2001.henriabu;

import no.ntnu.idatt2001.henriabu.henriabu.BonusMember;
import no.ntnu.idatt2001.henriabu.henriabu.MemberArchive;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
public class MemberArchiveTest {
    @Nested
    class Testing{
        BonusMember member = new BonusMember(6, LocalDate.now(),20000, "Johannes",
                "JohannesSinMail");
        MemberArchive archive = new MemberArchive();

        @Test
        @DisplayName("Checks if member added returns true")
        public void addMemberShouldReturnTrue(){
            assertTrue(archive.addMember(member));
        }
        @Test
        @DisplayName("Checks if points are added")
        public void pointsShouldEqual40000(){
            member.registerBonusPoints(20000);
            assertEquals(40000, member.getBonusPointsBalance());
        }
        @Test
        @DisplayName("Cheks if member is member with existing membernumber is added")
        public void memberShouldNotBeAdded(){
            BonusMember member2 = new BonusMember(6, LocalDate.now(), 1000,
                    "Tiril", "epost@epost.epost");
            archive.addMember(member2);
            BonusMember member3 = new BonusMember(6, LocalDate.now(), 2000,
                    "Søstern til Tiril", "mail@mail.mail");
            assertFalse(archive.addMember(member3));
        }
    }
}
