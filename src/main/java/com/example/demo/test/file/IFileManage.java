package com.example.demo.test.file;

import java.io.IOException;

public interface IFileManage {

	String chunkUploadByMappedByteBuffer(MultipartFileParam param) throws IOException;

}
