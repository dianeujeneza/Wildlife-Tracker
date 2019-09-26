import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class SightingsTest {
    @Rule
    public DatabaseRule database = new DatabaseRule();

    @Test
    public void Sighting_InstantiatesCorrectly_True(){
        Sightings newsighting = new Sightings("Alias","Zone 1",3);
        assertTrue( newsighting instanceof Sightings);
    }
    @Test
    public void Sighting_IsSavedOnDataBase_True(){
        Sightings newSighting = new Sightings("Alias","Zone 2",2);
        newSighting.save();
        assertTrue(Sightings.all().get(0).equals(newSighting));
    }
    @Test
    public void sighting_EachSightingIsAssignedAnId_getId(){
        Sightings newSighting = new Sightings("Gordon","Zone 2",1);
        newSighting.save();
        Sightings testSighting = Sightings.all().get(0);
        assertEquals(newSighting.getId(), testSighting.getId());
    }
    @Test
    public void find_WillReturnSightingWithTheSameID_SecondSighting(){
        Sightings firstSighting = new Sightings("Jaguar","Zone 2",1);
        firstSighting.save();
        Sightings SecondSighting = new Sightings("Maxes","Zone 5",3);
        SecondSighting.save();
        assertEquals(SecondSighting, Sightings.find(SecondSighting.getId()));
    }
    @Test
    public void Sightings_CanBeDeletedFromDataBase_true() {
        Sightings newSighting = new Sightings("Bahama","Zone 5",1);
        newSighting.save();
        newSighting.delete();
        assertEquals(0, Sightings.all().size());
    }

}