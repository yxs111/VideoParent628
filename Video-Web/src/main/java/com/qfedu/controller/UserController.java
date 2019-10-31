package com.qfedu.controller;

import com.qfedu. pojo.User;
import com.qfedu. service.UserService;
import com.qfedu.utils.ImageCut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by Administrator on 2019/6/21.
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Value("${IMAGE_DIR}")
    String imageDir;

    @Value("${IMAGE_URL}")
    String imageURL;
    @Autowired
    private UserService userService;

    @RequestMapping("/loginUser.action")
    @ResponseBody
    public String login(User user,HttpSession session) {
        System.out.println(user);
        boolean result = userService.selectUser(user);
        System.out.println("result+++++++++++++++" + result);
        if (result){
            session.setAttribute("userAccount",user.getEmail());

        }
        return result  ? "success":"fail";

    }
    @RequestMapping("/insertUser.action")
    @ResponseBody
   public String register(User user){
        userService.insertUser(user);
        return "success";


   }
    @RequestMapping("/validateEmail.action")
    @ResponseBody
    public String loginEmail(String email) {
        boolean result = userService.loginEmail(email);

       if (result){
           return "success";
       }else {
           return "fail";
       }


    }
    @RequestMapping("/showMyProfile")
    public String showMyProfile (Model model, HttpSession session){
        String email= (String) session.getAttribute("userAccount");
        User user =userService.selectUserByEmail(email);
        model.addAttribute("user",user);
        return "before/my_profile";

    }
    @RequestMapping("/changeProfile")
    public String editMyInfo (Model model, HttpSession session){
        String email = (String) session.getAttribute("userAccount");
        User user = userService.selectUserByEmail(email);
        model.addAttribute("user",user);
        return "before/change_profile";
    }
    @RequestMapping("/changeAvatar")
    public String changeImage (Model model, HttpSession session){
        String email = (String) session.getAttribute("userAccount");
        User user = userService.selectUserByEmail(email);
        user.setImgurl(imageURL+user.getImgurl());
        System.out.println(imageURL+user.getImgurl());
        model.addAttribute("user",user);
        return "before/change_avatar";
    }
    @RequestMapping("/passwordSafe")
    public String passwordSafe(HttpSession session, Model model) {


        return "before/password_safe";
    }
    @RequestMapping("/updateUser")
    public String updateUser(User user){
        userService.updateUserById(user);
        return "redirect:/user/showMyProfile";
    }
    @RequestMapping("/upLoadImage")
    public String upLoadImage(HttpServletRequest request, MultipartFile image_file, HttpSession session) throws IOException {
        String x1 = request.getParameter("x1");
        String x2 = request.getParameter("x2");
        String y1 = request.getParameter("y1");
        String y2 = request.getParameter("y2");
        System.out.println(x1+"+++++++++");
        String oldFilename = image_file.getOriginalFilename();
        System.out.println(oldFilename);

        //只是为得到一个新的名字
        String suffixName = oldFilename.substring(oldFilename.lastIndexOf("."));
        String newFileName = UUID.randomUUID().toString().replace("-","")+suffixName;

        //为了将图片进行归类，我们可以以时间的形式进行文件夹的创建
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String dirName = dateFormat.format(date);
        String targetName = imageDir+ dirName;
        File file = new File(targetName);
        if(!file.exists()){
            file.mkdirs();
        }
        image_file.transferTo(new File(targetName,newFileName));

        //图片切割
        float x1Val = 0,x2Val = 0,y1Val =0,y2Val = 0,width=0,height=0;

        if(null != x1 && !x1.equals("")){
            x1Val = Float.parseFloat(x1);
            y1Val = Float.parseFloat(y1);
            x2Val = Float.parseFloat(x2);
            y2Val = Float.parseFloat(y2);
            width = x2Val-x1Val;
            height = y2Val -y1Val;
            ImageCut imageCut =new ImageCut();
            //System.out.println(targetName+newFileName);
            imageCut.cutImage(targetName+"\\"+newFileName,(int)x1Val,(int)y1Val,(int)width,(int)height);

        }

        String email = (String) session.getAttribute("userAccount");
        //保存到数据库
        userService.updateUserImageByEmail(dirName+"/"+newFileName,email);


        return "redirect:/user/showMyProfile";
    }


}
