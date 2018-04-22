package me.fansir.rtvideo;

import me.fansir.rtvideo.bean.VideoSearchBean;
import me.fansir.rtvideo.constant.StateCode;
import me.fansir.rtvideo.constant.UserRoleEnum;
import me.fansir.rtvideo.model.*;
import me.fansir.rtvideo.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@Rollback
public class RtVideoApplicationTests {

	@Autowired
	UserService userService;
	@Autowired
	RecordService recordService;
	@Autowired
	VideoService videoService;
	@Autowired
	RoleService roleService;
	@Autowired
	SubscribeService subscribeService;
	@Autowired
	RoomService roomService;
	@Autowired
	ConfigService configService;

	public static void main(String[] args) {
//		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
//		System.out.println(passwordEncoder.encode("123456"));
	}

	@Test
	public void userServiceTest() {
		User user = userService.getUserById(1L);
		assert user != null;

		user.setGmt_modified(new Date());
		userService.updateUser(user);

		String username = "unique";
		user.setUsername(username);
		Long id = userService.addUser(user);
		assert id != null && id > 0;

		user = userService.getUserByUsername(username);
		assert user.getId().equals(id);

		userService.deleteUser(id);
	}

	@Test
	public void recordServiceTest() {
		Long uid = 1L;
		Record record = new Record();
		record.setUserId(uid);
		record.setVideoId(2L);
		record.setState(StateCode.NORMAL);
		Long recId = recordService.addWatchRecord(record);
		assert recId != null && recId > 0;

		recId = recordService.addWatchRecord(uid, 3L);

		List<Long> vidList = recordService.listRecordVideoId(uid, null);
		assert vidList.size() == 3;

		recordService.deleteRecord(recId);
		recordService.deleteAllRecord(uid);
	}

	@Test
	public void videoServiceTest() {
		Video video = new Video();
		video.setName("Test");
		video.setCategoryId(1);
		video.setRtmpUrl("rtmp://");
		video.setOwnerId(1L);
		video.setState(StateCode.NORMAL);
		video.setIslive(true);
		video.setThumbnail("http://");
		video.setUv(10);
		video.setPv(10);

		Long vid = videoService.addVideo(video);

		Video video2 = new Video();
		video2.setId(vid);
		video2.setPv(20);
		videoService.updateVideo(video2);

		Video video3 = videoService.getVideoById(vid);
		assert video3.getPv().equals(20);

		List<Long> vidList = new ArrayList<>();
		vidList.add(vid);
		videoService.listVideoByVideoIds(vidList);

		VideoSearchBean searchBean = new VideoSearchBean();
		searchBean.setOwnerId(1L);
		searchBean.setState(StateCode.NORMAL);
		searchBean.setRtime(new Date());
		List<Video> videos = videoService.listVideoByParam(searchBean);
		assert videos.size() > 0;

		videoService.deleteVideo(vid);
	}

	@Test
	public void roleServiceTest() {

		List<Role> roleList = roleService.listRoleByUserId(1L);
		assert roleList.size() == 3;

		Long count = roleService.countUserByRoleId(UserRoleEnum.ROLE_VIEWER.getId());
		assert count > 1;
	}

	@Test
	public void subscribeServiceTest() {

//		Long id = subscribeService.addSubscribe(2L, 1L);
//		assert id > 0;

		List<Long> playerIdList = subscribeService.listSubscribePlayerId(2L, null);
		assert playerIdList.size() >= 1;

	}

	@Test
	public void configServiceTest() {

		List<Role> roleList = configService.listAllRole();
		assert roleList.size() >= 3;

		Role role = configService.getRoleById(UserRoleEnum.ROLE_VIEWER.getId());
		assert role.getName().equals(UserRoleEnum.ROLE_VIEWER.name());

		List<Category> categoryList = configService.listAllCategory();
		assert categoryList.size() >= 4;

		Category category = configService.getCategoryById(1);
		assert "游戏专区".equals(category.getName());

		List<String> urlList = configService.listRtmpServerUrl();
		assert urlList.size() >= 1;

	}

	@Test
	public void roomServiceTest() {
		Room room = roomService.getRoom(1L);
		assert room != null;
	}
}
