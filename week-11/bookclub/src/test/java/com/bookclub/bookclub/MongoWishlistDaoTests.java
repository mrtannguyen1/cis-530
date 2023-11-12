package com.bookclub.bookclub;


import com.bookclub.model.WishlistItem;
import com.bookclub.service.dao.WishlistDao;
import com.bookclub.service.impl.MongoWishlistDao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class MongoWishlistDaoTests {

    @Mock
    private MongoTemplate mongoTemplate;

    @InjectMocks
    private MongoWishlistDao wishlistDao;

    @Test
    public void addTest() {
        WishlistItem wishlistItem = new WishlistItem();
        wishlistDao.add(wishlistItem);
        verify(mongoTemplate, times(1)).save(eq(wishlistItem));
    }

    @Test
    public void updateTest() {
        WishlistItem existingItem = new WishlistItem();
        existingItem.setId("1");
        existingItem.setIsbn("123456");
        existingItem.setTitle("Book Title");
        existingItem.setUsername("user123");

        WishlistItem updatedItem = new WishlistItem();
        updatedItem.setId("1");
        updatedItem.setIsbn("789012");
        updatedItem.setTitle("Updated Title");
        updatedItem.setUsername("user123");

        when(mongoTemplate.findById(eq("1"), eq(WishlistItem.class))).thenReturn(existingItem);

        wishlistDao.update(updatedItem);

        verify(mongoTemplate, times(1)).findById(eq("1"), eq(WishlistItem.class));
    }

    @Test
    public void removeTest() {
        when(mongoTemplate.remove(any(Query.class), eq(WishlistItem.class))).thenReturn(null);
        assertTrue(wishlistDao.remove("1"));
        verify(mongoTemplate, times(1)).remove(any(Query.class), eq(WishlistItem.class));
    }

    @Test
    public void listTest() {
        String username = "user123";
        List<WishlistItem> expectedItems = Arrays.asList(new WishlistItem(), new WishlistItem());

        when(mongoTemplate.find(any(Query.class), eq(WishlistItem.class))).thenReturn(expectedItems);

        List<WishlistItem> actualItems = wishlistDao.list(username);

        assertEquals(expectedItems, actualItems);
        verify(mongoTemplate, times(1)).find(any(Query.class), eq(WishlistItem.class));
    }

    @Test
    public void findTest() {
        String itemId = "1";
        WishlistItem expectedItem = new WishlistItem();

        when(mongoTemplate.findById(eq(itemId), eq(WishlistItem.class))).thenReturn(expectedItem);

        WishlistItem actualItem = wishlistDao.find(itemId);

        assertEquals(expectedItem, actualItem);
        verify(mongoTemplate, times(1)).findById(eq(itemId), eq(WishlistItem.class));
    }
}
