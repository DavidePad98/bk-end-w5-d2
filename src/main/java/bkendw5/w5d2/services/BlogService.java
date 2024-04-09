package bkendw5.w5d2.services;

import bkendw5.w5d2.entities.BlogPost;
import bkendw5.w5d2.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

@Service
public class BlogService {
    private List<BlogPost> blogList = new ArrayList<>();

    public List<BlogPost> getAllBlogsList(){
        return this.blogList;
    }

    public BlogPost saveBlog(BlogPost b){
        Random rndm = new Random();
        b.setId(rndm.nextInt(1,100));
        this.blogList.add(b);
        return b;
    }

    public BlogPost findById(int id){
        BlogPost result = null;
        for (BlogPost b: this.blogList){
            if (b.getId() == id) result = b;
        }
        if (result == null) throw new NotFoundException(id);
        else return result;
    }

    public BlogPost findByIdAndUpdate(int id, BlogPost bMod){
        BlogPost result = null;
        for (BlogPost b: this.blogList){
            if (b.getId() == id) result = b;
            result.setTitle(bMod.getTitle());
            result.setCategory(bMod.getCategory());
            result.setContent(bMod.getContent());
            result.setLectureTime(bMod.getLectureTime());
        }
        if (result == null) throw new NotFoundException(id);
        else return result;
    }

    public void DeleteFromId(int id){
        Iterator<BlogPost> iterator = this.blogList.iterator();
        while(iterator.hasNext()){
            BlogPost current = iterator.next();
            if (current.getId() == id){
                iterator.remove();
            }
        }
    }
}
