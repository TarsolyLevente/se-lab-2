package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class TorpedoStoreTest {

  @Test
  void fire_Success(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    boolean result = store.fire(1);

    // Assert
    assertEquals(true, result);
  }

  @Test
  void single_fire_count(){
    // Arrange
    TorpedoStore store = new TorpedoStore(10);

    // Act
    store.fire(1);

    // Assert
    assertEquals(9, store.getTorpedoCount());
  }

  @Test
  void more_fire_than_torpedos_exception(){
    // Arrange
    TorpedoStore store = new TorpedoStore(1);

    // Act
    Exception exception = assertThrows(IllegalArgumentException.class, ()-> store.fire(2));

    // Assert
    assertEquals("numberOfTorpedos", exception.getMessage());
  }
  
  @Test
  void number_of_torpedos_less_than_1_exception(){
    // Arrange
    TorpedoStore store = new TorpedoStore(0);

    // Act
    Exception exception = assertThrows(IllegalArgumentException.class, ()-> store.fire(1));

    // Assert
    assertEquals("numberOfTorpedos", exception.getMessage());
  }
}
