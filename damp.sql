USE [master]
GO
/****** Object:  Database [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF]    Script Date: 17.12.2015 11:45:22 ******/
CREATE DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'TankDatabase', FILENAME = N'D:\Completed Programs\7 Semestr\Kursach\Tanks\TankApplication\App_Data\TankDatabase.mdf' , SIZE = 4160KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'TankDatabase_log', FILENAME = N'D:\Completed Programs\7 Semestr\Kursach\Tanks\TankApplication\App_Data\TankDatabase_log.ldf' , SIZE = 832KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET ARITHABORT OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET AUTO_CLOSE ON 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET AUTO_SHRINK ON 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET  DISABLE_BROKER 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET  MULTI_USER 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET DB_CHAINING OFF 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF]
GO
/****** Object:  Table [dbo].[category]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[category](
	[c_id] [int] IDENTITY(1,1) NOT NULL,
	[c_name] [nvarchar](50) NOT NULL,
	[c_icon] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[c_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[chassis]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[chassis](
	[c_id] [int] NOT NULL,
	[c_name] [nvarchar](50) NOT NULL,
	[c_max_load] [float] NOT NULL,
	[c_rotate] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[c_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[country]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[country](
	[c_id] [int] IDENTITY(1,1) NOT NULL,
	[c_name] [nvarchar](50) NOT NULL,
	[c_flag] [nvarchar](100) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[c_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[crew]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[crew](
	[c_id] [int] NOT NULL,
	[c_type] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[c_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[engine]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[engine](
	[e_id] [int] NOT NULL,
	[e_name] [nvarchar](50) NOT NULL,
	[e_file_probability] [int] NOT NULL,
	[e_power] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[e_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[favorite]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[favorite](
	[f_id] [int] IDENTITY(1,1) NOT NULL,
	[u_id] [int] NOT NULL,
	[tank_id] [int] NOT NULL,
	[tw_id] [int] NOT NULL,
	[tt_id] [int] NOT NULL,
	[tc_id] [int] NOT NULL,
	[tr_id] [int] NOT NULL,
	[te_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[f_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[radiostation]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[radiostation](
	[r_id] [int] NOT NULL,
	[r_range] [int] NOT NULL,
	[r_name] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[r_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[role]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[role](
	[r_id] [int] NOT NULL,
	[r_role] [nvarchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[r_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tank]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tank](
	[tank_id] [int] NOT NULL,
	[tank_health] [int] NOT NULL,
	[tank_name] [nvarchar](50) NOT NULL,
	[tank_weight] [int] NOT NULL,
	[tank_category_id] [int] NOT NULL,
	[tank_level] [int] NOT NULL,
	[tank_country_id] [int] NOT NULL,
	[tank_premium] [bit] NOT NULL,
	[tank_price] [int] NOT NULL,
	[tank_small_icon] [nvarchar](200) NOT NULL,
	[tank_big_icon] [nvarchar](200) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tank_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tank_chassis]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tank_chassis](
	[tc_id] [int] IDENTITY(1,1) NOT NULL,
	[tank_id] [int] NOT NULL,
	[c_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tc_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tank_crew]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tank_crew](
	[tc_id] [int] NOT NULL,
	[c_id] [int] NOT NULL,
	[tank_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tc_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tank_engine]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tank_engine](
	[te_id] [int] IDENTITY(1,1) NOT NULL,
	[tank_id] [int] NOT NULL,
	[e_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[te_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tank_radiostation]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tank_radiostation](
	[tr_id] [int] IDENTITY(1,1) NOT NULL,
	[tank_id] [int] NOT NULL,
	[r_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tr_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tank_tower]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tank_tower](
	[tt_id] [int] IDENTITY(1,1) NOT NULL,
	[tank_id] [int] NOT NULL,
	[t_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tt_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tank_weapon]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tank_weapon](
	[tw_id] [int] NOT NULL,
	[tank_id] [int] NOT NULL,
	[w_id] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[tw_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tower]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tower](
	[t_id] [int] NOT NULL,
	[t_name] [nvarchar](50) NOT NULL,
	[t_visibility] [int] NOT NULL,
	[t_health] [int] NOT NULL,
	[t_rotate] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[t_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[user]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[user](
	[u_id] [int] IDENTITY(1,1) NOT NULL,
	[u_login] [nvarchar](50) NOT NULL,
	[u_name] [nvarchar](50) NOT NULL,
	[u_password] [nvarchar](50) NOT NULL,
	[u_role] [int] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[u_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[weapon]    Script Date: 17.12.2015 11:45:22 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[weapon](
	[w_id] [int] NOT NULL,
	[w_rate] [float] NOT NULL,
	[w_name] [nvarchar](50) NOT NULL,
	[w_damage_first] [int] NOT NULL,
	[w_damage_second] [int] NULL,
	[w_damage_third] [int] NULL,
	[w_penetration_first] [int] NOT NULL,
	[w_penetration_second] [int] NULL,
	[w_penetration_third] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[w_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[user] ADD  DEFAULT ((3)) FOR [u_role]
GO
ALTER TABLE [dbo].[favorite]  WITH CHECK ADD  CONSTRAINT [FK_favorite_ToTank] FOREIGN KEY([tank_id])
REFERENCES [dbo].[tank] ([tank_id])
GO
ALTER TABLE [dbo].[favorite] CHECK CONSTRAINT [FK_favorite_ToTank]
GO
ALTER TABLE [dbo].[favorite]  WITH CHECK ADD  CONSTRAINT [FK_favorite_ToUser] FOREIGN KEY([u_id])
REFERENCES [dbo].[user] ([u_id])
GO
ALTER TABLE [dbo].[favorite] CHECK CONSTRAINT [FK_favorite_ToUser]
GO
ALTER TABLE [dbo].[tank]  WITH CHECK ADD  CONSTRAINT [FK_tank_ToCategory] FOREIGN KEY([tank_category_id])
REFERENCES [dbo].[category] ([c_id])
GO
ALTER TABLE [dbo].[tank] CHECK CONSTRAINT [FK_tank_ToCategory]
GO
ALTER TABLE [dbo].[tank]  WITH CHECK ADD  CONSTRAINT [FK_tank_ToCountry] FOREIGN KEY([tank_country_id])
REFERENCES [dbo].[country] ([c_id])
GO
ALTER TABLE [dbo].[tank] CHECK CONSTRAINT [FK_tank_ToCountry]
GO
ALTER TABLE [dbo].[tank_chassis]  WITH CHECK ADD  CONSTRAINT [FK_tank_chassis_ToChassis] FOREIGN KEY([c_id])
REFERENCES [dbo].[chassis] ([c_id])
GO
ALTER TABLE [dbo].[tank_chassis] CHECK CONSTRAINT [FK_tank_chassis_ToChassis]
GO
ALTER TABLE [dbo].[tank_chassis]  WITH CHECK ADD  CONSTRAINT [FK_tank_chassis_ToTank] FOREIGN KEY([tank_id])
REFERENCES [dbo].[tank] ([tank_id])
GO
ALTER TABLE [dbo].[tank_chassis] CHECK CONSTRAINT [FK_tank_chassis_ToTank]
GO
ALTER TABLE [dbo].[tank_crew]  WITH CHECK ADD  CONSTRAINT [FK_tank_crew_ToCrew] FOREIGN KEY([c_id])
REFERENCES [dbo].[crew] ([c_id])
GO
ALTER TABLE [dbo].[tank_crew] CHECK CONSTRAINT [FK_tank_crew_ToCrew]
GO
ALTER TABLE [dbo].[tank_crew]  WITH CHECK ADD  CONSTRAINT [FK_tank_crew_ToTank] FOREIGN KEY([tank_id])
REFERENCES [dbo].[tank] ([tank_id])
GO
ALTER TABLE [dbo].[tank_crew] CHECK CONSTRAINT [FK_tank_crew_ToTank]
GO
ALTER TABLE [dbo].[tank_engine]  WITH CHECK ADD  CONSTRAINT [FK_tank_engine_ToEngine] FOREIGN KEY([e_id])
REFERENCES [dbo].[engine] ([e_id])
GO
ALTER TABLE [dbo].[tank_engine] CHECK CONSTRAINT [FK_tank_engine_ToEngine]
GO
ALTER TABLE [dbo].[tank_engine]  WITH CHECK ADD  CONSTRAINT [FK_tank_engine_ToTank] FOREIGN KEY([tank_id])
REFERENCES [dbo].[tank] ([tank_id])
GO
ALTER TABLE [dbo].[tank_engine] CHECK CONSTRAINT [FK_tank_engine_ToTank]
GO
ALTER TABLE [dbo].[tank_radiostation]  WITH CHECK ADD  CONSTRAINT [FK_tank_radiostation_ToRadionstation] FOREIGN KEY([r_id])
REFERENCES [dbo].[radiostation] ([r_id])
GO
ALTER TABLE [dbo].[tank_radiostation] CHECK CONSTRAINT [FK_tank_radiostation_ToRadionstation]
GO
ALTER TABLE [dbo].[tank_radiostation]  WITH CHECK ADD  CONSTRAINT [FK_tank_radiostation_ToTank] FOREIGN KEY([tank_id])
REFERENCES [dbo].[tank] ([tank_id])
GO
ALTER TABLE [dbo].[tank_radiostation] CHECK CONSTRAINT [FK_tank_radiostation_ToTank]
GO
ALTER TABLE [dbo].[tank_tower]  WITH CHECK ADD  CONSTRAINT [FK_tank_tower_ToTank] FOREIGN KEY([tank_id])
REFERENCES [dbo].[tank] ([tank_id])
GO
ALTER TABLE [dbo].[tank_tower] CHECK CONSTRAINT [FK_tank_tower_ToTank]
GO
ALTER TABLE [dbo].[tank_tower]  WITH CHECK ADD  CONSTRAINT [FK_tank_tower_ToTower] FOREIGN KEY([t_id])
REFERENCES [dbo].[tower] ([t_id])
GO
ALTER TABLE [dbo].[tank_tower] CHECK CONSTRAINT [FK_tank_tower_ToTower]
GO
ALTER TABLE [dbo].[tank_weapon]  WITH CHECK ADD  CONSTRAINT [FK_tank_weapon_ToTank] FOREIGN KEY([tank_id])
REFERENCES [dbo].[tank] ([tank_id])
GO
ALTER TABLE [dbo].[tank_weapon] CHECK CONSTRAINT [FK_tank_weapon_ToTank]
GO
ALTER TABLE [dbo].[tank_weapon]  WITH CHECK ADD  CONSTRAINT [FK_tank_weapon_ToWeapon] FOREIGN KEY([w_id])
REFERENCES [dbo].[weapon] ([w_id])
GO
ALTER TABLE [dbo].[tank_weapon] CHECK CONSTRAINT [FK_tank_weapon_ToWeapon]
GO
ALTER TABLE [dbo].[user]  WITH CHECK ADD  CONSTRAINT [FK_user_ToRole] FOREIGN KEY([u_role])
REFERENCES [dbo].[role] ([r_id])
GO
ALTER TABLE [dbo].[user] CHECK CONSTRAINT [FK_user_ToRole]
GO
USE [master]
GO
ALTER DATABASE [D:\COMPLETED PROGRAMS\7 SEMESTR\KURSACH\TANKS\TANKAPPLICATION\APP_DATA\TANKDATABASE.MDF] SET  READ_WRITE 
GO
