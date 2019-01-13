/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : jdbc

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2019-01-13 14:25:26
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `article`
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `articleId` int(25) NOT NULL AUTO_INCREMENT,
  `articleName` varchar(255) DEFAULT NULL,
  `article` text,
  `articleDate` datetime DEFAULT NULL,
  `author` varchar(25) DEFAULT NULL,
  `typeId` int(25) DEFAULT NULL,
  `commentCount` int(25) DEFAULT NULL,
  `readCount` int(25) DEFAULT NULL,
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=50 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of article
-- ----------------------------
INSERT INTO `article` VALUES ('6', '第三次', '看看看看飞飞飞儿的方法发图提供好订单的无无撒', '2017-12-30 11:46:38', '赖红', '4', '0', '2');
INSERT INTO `article` VALUES ('10', '方法鹅鹅鹅', '非凡任务卧式铣床v数数数到多多付费的搜索出存储的你你你吧爸爸', '2017-12-30 13:27:21', '赖红', '1', '0', '2');
INSERT INTO `article` VALUES ('28', '111111111', '请输入内容三四十万无无哇奥奥奥', '2018-01-03 09:27:19', '王八', '4', '0', '0');
INSERT INTO `article` VALUES ('29', '777', '请输入内容我问问翁二二多多付', '2018-01-03 09:36:12', '王八', '1', '0', '1');
INSERT INTO `article` VALUES ('32', '999', '<p>方法就觉得觉得<br/></p>', '2018-01-03 11:25:58', '王八', '1', '1', '2');
INSERT INTO `article` VALUES ('33', '77888', '<p>对对对分深色<br/></p>', '2018-01-03 11:34:36', '王八', '1', '0', '0');
INSERT INTO `article` VALUES ('34', '44', '<p>对对对谁谁谁啊啊啊啊<img src=\"http://img.baidu.com/hi/jx2/j_0001.gif\"/></p>', '2018-01-03 12:24:09', '王八', '2', '0', '13');
INSERT INTO `article` VALUES ('35', '最后好了', '<p>对对对谁说的<img src=\"http://localhost:8080/static/image/20180103/1514954859984010855.jpg\" title=\"1514954859984010855.jpg\" alt=\"QQ截图20171206201034.jpg\"/><br/></p>', '2018-01-03 12:47:46', '王八', '1', '0', '1');
INSERT INTO `article` VALUES ('36', '再次再次测试', '<p>时尚达人方法给搞好<img src=\"http://localhost:8080/static/image/20180103/1514955240108021895.png\" title=\"1514955240108021895.png\" alt=\"微信截图_20171209172321.png\"/><br/></p>', '2018-01-03 12:54:07', '王八', '1', '0', '2');
INSERT INTO `article` VALUES ('37', '5555557777', '<p>滴滴打人人人滚滚滚<img src=\"http://localhost:8080/static/image/20180103/1514962491178064015.jpg\" title=\"1514962491178064015.jpg\" alt=\"QQ截图20171208214721.jpg\"/></p>', '2018-01-03 14:55:14', '王八', '2', '0', '0');
INSERT INTO `article` VALUES ('38', '测试类型', '<p>等的可开发<img src=\"http://img.baidu.com/hi/jx2/j_0001.gif\"/></p>', '2018-01-03 20:26:48', '王八', '1', '0', '0');
INSERT INTO `article` VALUES ('39', '测试类型', '<p>时时刻刻佛罗里达快捷酒店<img src=\"http://img.baidu.com/hi/jx2/j_0001.gif\"/></p>', '2018-01-03 20:29:47', '王八', '1', '0', '0');
INSERT INTO `article` VALUES ('40', '测试类型数量', '<p>发放人热的地方GV<br/></p>', '2018-01-03 20:31:49', '王八', '1', '0', '0');
INSERT INTO `article` VALUES ('41', '测试类型', '<p>升水流量的慷慨大方<br/></p>', '2018-01-03 20:39:29', '王八', '1', '0', '0');
INSERT INTO `article` VALUES ('45', '测试类型数量', '<p>升水多点康复科<br/></p>', '2018-01-03 21:01:55', '王八', '1', '0', '0');
INSERT INTO `article` VALUES ('49', '测试类型', '<p>大大方方看看开发<br/></p>', '2018-01-03 21:31:45', '王八', '1', '0', '0');

-- ----------------------------
-- Table structure for `comment`
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `cid` int(25) NOT NULL AUTO_INCREMENT,
  `content` varchar(500) DEFAULT NULL,
  `commentDate` datetime DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `articleId` int(25) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '再来测试', '2018-01-06 10:41:44', '王八', '32');

-- ----------------------------
-- Table structure for `life`
-- ----------------------------
DROP TABLE IF EXISTS `life`;
CREATE TABLE `life` (
  `lifeId` int(11) NOT NULL AUTO_INCREMENT,
  `lifeName` varchar(255) DEFAULT NULL,
  `lifeContent` text,
  `readNum` int(11) DEFAULT NULL,
  `releaseTime` date DEFAULT NULL,
  PRIMARY KEY (`lifeId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of life
-- ----------------------------
INSERT INTO `life` VALUES ('1', '吃在东软', '　目前，学校有位于二期公寓出口处的东软学一食堂。二楼和三楼的大众餐厅设有五十个左右的菜色品种，菜价（含米饭、汤）从三元起价位不等，以及各类面食可供选择。\r\n（东软学一食堂咨询电话0757-81206844）\r\n在学院教学楼与行政楼附近有东软学二食堂，即时出售饭票，餐厅提供5元的套餐和点菜服务。\r\n \r\n　　特别介绍：膳食委员会——为了切实加强我院饭堂管理工作，深化我院后勤社会化改革，确保我院正常生活秩序，维护学生的合法权益，2007年9月，在院党委与院团委的指导下，学院特别成立“膳食委员会”， 以作为学生自我参与管理的机构，常设院学生会。膳食委员会成立后将始终坚持以为广大同学服务为宗旨，本着“团结、务实、创新”的工作原则，紧紧围绕学生膳食开展工作，收集学生的意见，充分发挥各种职能，稳步而高质量地推动各项工作的有效开展，真正建设成为一支强大高效，团结拼搏的干部队伍。', '0', '2018-01-04');
INSERT INTO `life` VALUES ('2', '住在东软', '学校的住宿条件及收费标准\r\n　　按国家高校后勤社会化标准建设，实行封闭式公寓化管理，所有寝室均配备网络接口、电热水器、饮水机等。公寓区内医疗、生活等服务设施一应俱全。\r\n　　学院学生公寓，住宿标准是1700元/人/年。\r\n　　学生公寓的出入时间为：6：00—23：00(周日-周四)\r\n　　　　　　　　　　　　　6：00—23：30(周五-周六)。\r\n\r\n住宿疑问\r\n学院的物业管理是哪家物业公司？\r\n　广州虹宇物业管理公司是学院生活区的物业管理公司。\r\n如果忘带钥匙怎么办？\r\n　　先到所属宿舍宿管员处写借条，由宿管员签名确认后，再到公寓管理中心领取备用钥匙，使用后需立即归还。\r\n如果有来访人员，如何处理？对搬入、搬出的物品如何处理？\r\n　　来访人员不得随便出入生活区。若想进入生活区，则需在所辖保安亭处进行身份核实并登记，方可进入；如有搬入、搬出物品，则需在所辖保安亭处进行核查确认。搬出物品需到物业管理中心办理“放行条”方可放行。\r\n生活区可使用什么交通工具吗？\r\n　　除因工作需要的交通工具允许进入外，其它车辆（含摩托车）一概严禁入内。\r\n生活区可以送外卖吗？\r\n　　严格执行学院管理规定，严禁送外卖进入。\r\n生活区什么时间关门？\r\n　　严格执行学院规定的关门时间，周日至周四晚上为11:00，周五至周六晚上为11:30。在关门时间之后回宿舍的学生须凭学生证或校园卡，进行登记后方可进入；如无学生证或校园卡者，则需致电辅导员进行核实确认后，方可进入。\r\n宿舍内的物品需维修时怎么办（例如电话、热水器等）？\r\n　　宿舍内需要维修的物品或设施，师生可直接到物业进行登记受理，预约时间上门维修。如果固定电话坏了可拨打10000进行报修；由学院承担维修的热水器，也需到物业报修、登记，由物业及时通知维修单位上门维修。\r\n物业在新生入学前会进行宿舍维修吗？ 新生入学后一个月内若发现宿舍内有设施损坏需要维修的，维修费用是学院负责吗？\r\n　　是的。学院在新生入学前会对宿舍进行检查、维修工作。新生入学后一个月内，如有设施自然损坏，学院将负责维修宿舍内各类设施，由物业负责执行，学生不需承担费用。新生入学一个月后将属于有偿服务。', '0', '2018-01-04');
INSERT INTO `life` VALUES ('3', '行在东软', '园区公交车路线\r\n230路：（南海线路 广佛路口站） 06:00--19:00 小塘走马营 06:00--19:00每15-25分钟一班\r\n途径站点：广佛路口站 - 广佛路东 - 黄岐城区 - 宏威路口 - 嘉洲广场 - 大转弯(黄岐凯民茶博城) - 盐步路口 - 横江 - 江河路 - 平安 - 泗沥 - 岭南 - 江夏村 - 蛇龙北 - 日发市场 - 大沥城区南(新都会) - 大沥城区北 - 大沥摩托车市场 - 小布[大沥] - 综合市场(大沥车站) - 高边 - 颜峰 - 兴贤牌坊 - 丹邱村 - 小洞村 - 佛山科技学院[大沥] - 仙溪 - 长虹岭工业园 - 软件信息园路口 - 创新楼路口 - 华师大南海学院 - 生活二区路口 - 大学城北商业区 - 广东轻工职业技术学院 - 穆院村 - 狮山高速路口 - 狮山(小塘路口) - 狮山华立医院 - 华涌 - 大涡塘 - 狮南路口 - 莲子塘 - 莲塘 - 狮岭(陈边) - 走马营 (45站)\r\n \r\n佛山245路A线：（南海线路 罗村总站） 06:30--19:00 狮山大学城 06:30--19:00每25分钟一班\r\n途径站点：罗村总站 - 罗村高中 - 罗村政府 - 罗村医院 - 医院西站 - 下柏立交 - 上柏 - 白沙桥[狮山] - 兴业路口[一环] - 狮山工业园市场 - 塘头幼儿园 - 下旺田村 - 狮山政府 - 南海湖景湾 - 石门中学(狮山) - 红星路口 - 狮山高速路口 - 穆院村 - 软件信息园路口 - 创新楼路口 - 华师大南海学院 - 生活二区路口 - 大学城北商业区 - 广东轻工职业技术学院 - 阳光在线广场 (25站)\r\n \r\n佛山275路：　(坑口公交场－广东轻工职业技术学院)　 广东轻工职业技术学院总站<—>广州坑口公交场总站（头班车6：30，尾班车20：00，每15分钟一班）\r\n途径站点： 坑口公交场 - 芳村客运站 - 浣花路 - 东漖北路 - 茶滘 - 穗盐路 - 东秀市场 - 雅居乐北门 - 河东村委 - 虎榜市场 - 虎榜路口 - 联桂路东 - 小桥 - 广东南国小商品城 - 中大小商品城 - 泗沥 - 岭南 - 江夏 - 大沥城区南 - 大沥商业步行街 - 凤池 - 大沥政府 - 小布 - 综合市场(大沥车站) - 高边 - 颜峰 - 兴贤 - 小洞村 - 佛山科技学院 - 长虹岭科技园 - 南海软件科技园路口 - 华师大 – 东软 - 广东轻工职业技术学院(共34站)\r\n\r\n280路：广东轻工职业技术学院总站<—>新城区公交枢纽站（头班车6：30，尾班车20：00，每15分钟一班）\r\n途径站点：轻工职业技术学院总站，东软信息技术学院，华师大南海学院，石油化工学院，大学城北区站，聚龙村，科技院A区，松夏市场，显子岗（桃园路口），石碣路口，联表，松岗公安分局，松岗站，松岗镇政府，显岗（金叶阳光新城），大沥车站路口，大沥摩托车市场，大沥城区南，大沥商业步行街，凤池，太平村，钟边村，大镇，谢边，机场路，佛山大桥（乐安），广佛车站（火车站路口），佛山火车站，人民西（7妇幼保健院），科学馆，城门头南，佛山体育馆，佛山市三中，市二医院，佛山市政府，南浦村，佛山明珠体育馆西门，禅城区政府，市一医院，深村，永红村，石梁东，东平大桥北，世纪莲体育馆，新城区公交站枢纽站\r\n\r\n211路：（星期五下午到星期天会进入科技园，其他时间不一定会进的）头班车7:30，尾班车18:00，每15分钟一班；\r\n途径站点：南海车站(家天下广场) - 雷岗公园南门 - 西约 - 桂城加油站 - 军桥东 - 军桥 - 南海医院 - 佛平路口 - 禅城区卫生监督所 - 新堤路 - 中山桥 - 中山公园 - 汾江立交 - 文昌路 - 佛山火车站 - 敦厚 - 佛山大桥(乐安) - 机场路口 - 谢边 - 大镇 - 钟边 - 太平村 - 凤池 - 大沥商业步行街 - 大沥城区北 - 摩托车市场 - 小布 - 综合市场(大沥车站) - 高边 - 颜峰 - 兴贤 - 小洞村 - 佛山科技学院北院 - 长虹岭工业园 - 软件信息园路口 - 华师大 - 广东轻工职业技术学院 - 穆院村 - 狮山高速路口 - 狮山(小塘路口) - 狮山华立医院 - 华涌 - 邹边 - 罗洞 - 小榄(金三角) - 狮北(银岗) - 狮北市场 - 狮西(华平)(48站)', '0', '2018-01-04');
INSERT INTO `life` VALUES ('4', '娱乐活动', '　　学院各项体育设施齐全、设备优良，其中体育馆就是锻炼身体、运动和娱乐的好去处。目前学院体育馆内设有：篮球场、乒乓球台、羽毛球场、排球场；（室外）体育设施有：篮球场、足球场、田径场和网球场。为同学提供免费的体育运动设施（网球场除外），让师生在课余时间进行更好的运动。\r\n　　开放时间：\r\n　　星期一至星期五：6:30——8:20 17:20——21:30\r\n　　双休日：8:00——11:30 14:30——21:30\r\n　　注：周三下午3:00——6:00为教师活动时间，如有特殊情况将另行通知。', '0', '2018-01-04');

-- ----------------------------
-- Table structure for `type`
-- ----------------------------
DROP TABLE IF EXISTS `type`;
CREATE TABLE `type` (
  `typeId` int(25) NOT NULL AUTO_INCREMENT COMMENT '类型Id',
  `typeName` varchar(255) DEFAULT NULL COMMENT '类型名称',
  `articleCount` int(25) DEFAULT NULL COMMENT '文章数量',
  PRIMARY KEY (`typeId`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of type
-- ----------------------------
INSERT INTO `type` VALUES ('1', '生活1', '1');
INSERT INTO `type` VALUES ('2', '学习', '0');
INSERT INTO `type` VALUES ('3', '情感', '0');
INSERT INTO `type` VALUES ('4', '影视', '0');
INSERT INTO `type` VALUES ('5', '旅行', '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `uname` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `password2` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `major` varchar(255) DEFAULT NULL,
  `preferences` varchar(255) DEFAULT NULL,
  `others` varchar(500) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', '李四', '444444', '444444', '856396478@qq.com', '男', '数字媒体艺术', '唱歌,跳舞,溜冰', '  勤奋好学');
INSERT INTO `user` VALUES ('4', '王五', '555555', '555555', '758963547@qq.com', '男', '日语', '看剧', '凤飞飞军军付或或军军军军偶偶偶，浪费了看见');
INSERT INTO `user` VALUES ('7', '王八', '888888', '888888', '423659878@qq.com', '男', '软件工程', '唱歌,看剧,溜冰', '能歌善舞');
INSERT INTO `user` VALUES ('8', '赵六', '666666', '666666', '254689785@qq.com', '女', '软件工程', '溜冰,看剧', '有志青年');
INSERT INTO `user` VALUES ('9', '胡七', '777777', '777777', '5632489568@qq.com', '男', '软件工程', '唱歌', '游戏超级玩家');
INSERT INTO `user` VALUES ('10', '吴武', '123123', '123123', '456258796@qq.com', '男', '电子信息工程', '跳舞', null);
INSERT INTO `user` VALUES ('11', '陈丽', '456456', '456456', '895632475@qq.com', '女', '电子信息工程', '看剧', ' 反反复复付付付多的二拖晕晕或女木');
INSERT INTO `user` VALUES ('12', '邓凯', '789789', '789789', '8564523679@qq.com', '男', '软件工程', '唱歌', null);
INSERT INTO `user` VALUES ('13', '区刊', '147147', '147147', '875632597@qq.com', '女', '软件工程', '溜冰', null);
INSERT INTO `user` VALUES ('14', '林恺俊', '258258', '258258', '741586395@qq.com', '男', '软件工程', '唱歌,跳舞', null);
INSERT INTO `user` VALUES ('15', '赖红', '111111', null, '111111', '男', '软件工程', null, null);
