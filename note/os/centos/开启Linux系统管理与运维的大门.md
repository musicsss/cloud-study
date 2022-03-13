# Linux版本问题

## Linux的内核版本

    Linux内核由C语言编写，符合POSIX标准。Linux内涵和只提供基本的设备驱动、文件管理、资源管办理等功能。

## Linux的发行版本
+ Ubuntu： 友好的桌面系统。
+ openSUSE、Fedora、Debian
+ Centos： 源码来自与Red Hat Enterprise Linux（RHEL），其社区提供及时的安全更新和软件升级服务，是一个企业级发行版，适用于普通开发者和服务器领域。

# CentOS 之于Linux

CentOS（Community Enterprise Operating System， 社区企业操作系统）

## CentOS简介

    CentOS是根据RHEL释出的源代码进行二次编译而成，删除了RHEL相关的图标等具有商业版权的信息后。

### CentOS 与RHEL 不同之处

1. RHEL中包含了红帽自行开发的闭源软件，这些软件并未开放源代码，因此也就未包含在CentOS发行版中
2. CentOS发行版通常会修改RHEL中存在的一些BUG，并提供了一个yum源以便用户可以随时更新操作系统。
3. CentOS并不提供任何形式的技术支持

## CentOS7的最新改进
1. 更新内核版本为3.10.0： 新版本的内核将对swap内存空间进行压缩，这将显著提高I/O性能；优化KVM虚拟化支持；开启固态硬盘和机械硬盘框架，同时使用这两种硬盘的系统将会提速；更新和改进了图形、音频声音驱动等。
2. 文件系统方面： 默认支持了XFS文件系统，并更新了KVM，使其可以支持ext4和XFS快照。
3. 网络方面： 支持Firewalld（动态防火墙），防火墙现在可以支持区域和网络信任，配置防火墙之后也不需要重新启动防火墙就可以应用配置了；更新了高性能网络驱动等。
4. 支持Linux容器：Linux容器能提供轻量化的虚拟化，一边隔离进程和资源，浙江提高资源的使用效率。
5. 用Systemd 替代SysVinit： 更好的服务管理光加能使存在依赖的服务之间更好地并行化。