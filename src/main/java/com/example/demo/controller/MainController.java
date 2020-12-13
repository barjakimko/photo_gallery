package com.example.demo.controller;

import com.example.demo.dto.GalleryDto;
import com.example.demo.dto.PhotoDto;
import com.example.demo.dto.UserDto;
import com.example.demo.entity.ApplicationUser;
import com.example.demo.entity.Gallery;
import com.example.demo.entity.Photo;
import com.example.demo.service.AccountTypeService;
import com.example.demo.service.GalleryService;
import com.example.demo.service.PhotoService;
import com.example.demo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private PhotoService photoService;
    private GalleryService galleryService;
    private UserService userService;
    private AccountTypeService accountTypeService;

    public Set<Photo> photos = new HashSet<>();
    //should be public to possible clean list from controller


    public MainController(PhotoService photoService,
                          GalleryService galleryService,
                          UserService userService,
                          AccountTypeService accountTypeService) {
        this.photoService = photoService;
        this.galleryService = galleryService;
        this.userService = userService;
        this.accountTypeService = accountTypeService;
    }

    @GetMapping("/customer/galleries")
    String getWelcomePageForCustomer(Model model, HttpServletRequest request) {

        HttpSession session = request.getSession(true);
        ApplicationUser customer = (ApplicationUser) session.getAttribute("customer");

        model.addAttribute("customer", customer);

        model.addAttribute("photos", photos);

        return "customer";
    }

    @GetMapping("/customer/gallery/{id}")
    String getPhotosByGalleryId(@PathVariable("id") Long galleryId, Model model) {

        this.photos = galleryService.findById(galleryId).getPhotos();

        return "redirect:/customer/galleries";
    }

    @GetMapping("/photographer/users")
    String getWelcomePageForPhotographer(Model model, HttpServletRequest request) {

        List<ApplicationUser> applicationUsers = userService.getAllUsers();

        HttpSession session = request.getSession(true);

        UserDto userDto = new UserDto();

        List<String> logins = applicationUsers.stream()
                .map(user -> user.getLogin())
                .collect(Collectors.toList());

        model.addAttribute("allUsers", applicationUsers);
        model.addAttribute("logins", logins);
        model.addAttribute("userDto", userDto);

        return "photographer";
    }

    @PostMapping("/photographer/new-users")
    String addNewUser(@ModelAttribute("user-dto") UserDto userDto) {

        ApplicationUser applicationUser = new ApplicationUser(userDto.getLogin(), userDto.getPassword());
        applicationUser.setAccountType(
                accountTypeService.findAccountTypeById(1L));

        userService.saveUser(applicationUser);

        return "redirect:/photographer/users";
    }

    @GetMapping("/photographer/users/{id}")
    String getUser(@PathVariable("id") Long Id, Model model) {
        ApplicationUser customer = userService.findUserById(Id);
        model.addAttribute("customer", customer);

        GalleryDto galleryDto = new GalleryDto();
        model.addAttribute("galleryDto", galleryDto);

        return "edit-user";
    }

    @PostMapping("/photographer/users/{id}")
    String addNewGallery(@ModelAttribute("galleryDto") GalleryDto galleryDto,
                         @PathVariable("id") Long id) {

        Gallery gallery = new Gallery(galleryDto.getName(), galleryDto.getPassword());

        ApplicationUser userById = userService.findUserById(id);
        userById.getGalleries().add(gallery);
        userService.saveUser(userById);

        return "redirect:/photographer/users/{id}";
    }

    @GetMapping("/photographer/users/galleries/1")
    String getUserGalleries(@PathVariable("id") Long Id, Model model) {
        ApplicationUser customer = userService.findUserById(Id);
        model.addAttribute("customer", customer);

        return "add-gallery";
    }


    @GetMapping("/logout")
    public void processLogout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        HttpSession session = request.getSession(true);
        if (session != null) {
            session.invalidate();
        }
        photos.clear();

        response.sendRedirect(request.getContextPath() + "/loginForm");
    }

    @GetMapping("/galleries/{id}")
    String getGallery(@PathVariable("id") Long id, Model model) {

        Gallery gallery = galleryService.findById(id);
        model.addAttribute("gallery", gallery);

        PhotoDto photoDto = new PhotoDto();
        model.addAttribute("photoDto", photoDto);

        return "edit-gallery";
    }

    @PostMapping("/galleries/{id}")
    String addNewGallery(@ModelAttribute("photoDto") PhotoDto photoDto,
                         @PathVariable("id") Long galleryId) {

        Photo photo = new Photo("/photos/" + photoDto.getUrl());

        Gallery gallery = galleryService.findById(galleryId);
        gallery.getPhotos().add(photo);
        galleryService.saveGallery(gallery);

        return "redirect:/galleries/{id}";
    }
}
