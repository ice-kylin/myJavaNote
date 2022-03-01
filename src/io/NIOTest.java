package io;

/*
# NIO 2

## `Path` 常用方法

- `String toString()`：返回调用 `Path` 对象的字符串表示形式
- `boolean startsWith(String path)`：判断是否以 `path` 路径开始
- `boolean endsWith(String path)`：判断是否以 `path` 路径结束
- `boolean isAbsolute()`：判断是否为绝对路径
- `Path getParent()`：返回 `Path` 对象包含整个路径，不包含 `Path` 对象指定的文件路径
- `Path getRoot()`：返回调用 `Path` 对象的根路径
- `Path getFileName()`：返回与调用 `Path` 对象关联的文件名
- `int getNameCount()`：返回 `Path` 根目录后面元素的数量
- `Path getName(int idx)`：返回指定索引位置 `idx` 的路径名称
- `Path toAbsolutePath()`：作为绝对路径返回调用 `Path` 对象
- `Path resolve(Path p)`：合并两个路径，返回合并后的路径对应的 `Path` 对象
- `File toFile()`：将 `Path` 转换为 `File` 类的对象

## `Files` 类

- 用于操作文件或者目录的工具类
- 常用方法
  - `Path copy(Path src, Path dest, CopyOption ... how)`：文件的复制
  - `Path creatDirectory(Path path, FileAttribute<?> ... attr)`：创建一个目录
  - `Path creatFile(Path path, FileAttribute<?> ... arr)`：创建一个文件
  - `void delete(Path path)`：删除一个目录 / 文件，如果不存在，则报错
  - `void deleteIfExists(Path path)`：Path 对应的文件 / 目录如果存在，则删除
  - `Path move(Path src, Path dest, CopyOption ... how)`：将 `src` 移动到 `dest` 位置
  - `long size(Path path)`：返回 `path` 指定文件的大小
- 用于判断
  - `boolean exists(Path path, LinkOption ... opts)`：判断文件是否存在
  - `boolean isDirectory(Path path, LinkOption ... opts)`：判断是否是目录
  - `boolean isRegularFile(Path path, LinkOption ... opts)`：判断是否是文件
  - `boolean isReadable(Path path)`：判断文件是否可读
  - `boolean isWriteable(Path path)`：判断文件是否可写
  - `boolean notExists(Path path, LinkOption ... opts)`：判断文件是否不存在
- 用于操作内容
  - `SeekableByteChannel newByteChannel(Path path, OpenOption ... how)`：获取与指定文件的连接，`how` 指定打开方式
  - `DirectoryStream<Path> newDirectoryStream(Path path)`：打开 `path` 指定的目录
  - `InputStream newInputStream(Path path, OpenOption ... how)`：获取 `InputStream` 对象
  - `OutputStream newOutputStream(Path path, OpenOption ... how)`：获取 `OutputStream` 对象
 */
public class NIOTest {
    public static void main(String[] args) {

    }
}
